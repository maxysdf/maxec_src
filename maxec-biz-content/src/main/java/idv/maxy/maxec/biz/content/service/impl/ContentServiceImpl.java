package idv.maxy.maxec.biz.content.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import idv.maxy.maxec.biz.content.dao.AdDao;
import idv.maxy.maxec.biz.content.model.Ad;
import idv.maxy.maxec.biz.content.service.ContentService;
import idv.maxy.maxec.biz.content.vo.AdItemVO;
import idv.maxy.maxec.biz.content.vo.AdVO;
import idv.maxy.maxec.core.util.FileUtil;
import idv.maxy.maxec.core.util.StringUtil;

/**
 * 
 * @author Max Chen
 *
 */
@Service
public class ContentServiceImpl implements ContentService {
	private static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);
	
	@Value("${app.data.basedir}")
	private String basedir;
	
	@Autowired
	private AdDao adDao;
	
	private Function<Ad, AdVO> M2V_AD = m -> {
		if(m == null) { return null; }
		AdVO v = new AdVO();
		v.setId(m.getId());
		v.setName(m.getName());
		v.setCode(m.getCode());
		
		m.getAdItems().forEach(mi -> {
			AdItemVO vi = new AdItemVO();
			vi.setId(mi.getId());
			vi.setImageAlt(mi.getImageAlt());
			vi.setImageLink(mi.getImageLink());
			vi.setImagePath(mi.getImagePath());
			vi.setOpenNew(Boolean.TRUE.equals(mi.getIsOpenNew()));
			v.getItems().add(vi);
		});
		
		return v;
	};
	
	
	
	
	/**
	 * @param f
	 * @param path
	 */
	public void uploadFile(InputStream is, String path) throws Exception {
		if(StringUtil.isEmptyOrNull(path)) { throw new Exception("path is empty"); }
		if(!path.startsWith("/")) { throw new Exception("path not start with /"); }
		if(is == null) { throw new Exception("input is null"); }
		
		String pathdir = path.substring(0, path.lastIndexOf('/'));
		String pathfile = path.substring(path.lastIndexOf('/')+1);
		
		File pathdirFile = new File(basedir, pathdir);
		if(!pathdirFile.isDirectory()) { pathdirFile.mkdirs(); }
		File pathfileFile = new File(pathdirFile, pathfile);
		if(pathfileFile.isFile()) { throw new Exception("file exists"); }
		
		try(FileOutputStream fos = new FileOutputStream(pathfileFile)) {
			FileUtil.copy(is, fos);
		} catch(Exception ex) {
			logger.error("file upload fail", ex);
		}
	}
	
	/**
	 * 
	 * @param path
	 */
	public void deleteContent(String path) throws Exception {
		File f = new File(basedir, path);
		if(!f.isFile()) { throw new Exception("no found"); }
		f.delete();
	}
	

	/**
	 * 
	 * @param code
	 * @return
	 */
	public AdVO findAdByCode(String code) {
		Ad m = adDao.findByCode(code);
		return M2V_AD.apply(m);
	}
}
