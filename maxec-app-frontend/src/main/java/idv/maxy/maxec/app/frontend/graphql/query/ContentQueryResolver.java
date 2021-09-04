package idv.maxy.maxec.app.frontend.graphql.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.maxy.maxec.app.frontend.apiclient.ContentApiClient;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseVO;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseWrapperVO;
import idv.maxy.maxec.biz.content.vo.AdVO;

/**
 * 
 * @author Max Chen
 *
 */
@Component
public class ContentQueryResolver extends QueryResolver {
	private static final Logger logger = LoggerFactory.getLogger(ContentQueryResolver.class);
	
	@Autowired
	private ContentApiClient contentApiClient;
	
	// response types ----------------------------------------------------------------
	public static class AdResponse extends ResponseWrapperVO {
		private AdVO ad;
		public AdVO getAd() {
			return ad;
		}
		public void setAd(AdVO ad) {
			this.ad = ad;
		}
	}
	
	// methods --------------------------------------------------------------
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public AdResponse findAdByCode(String adCode) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		AdVO ad = null;
		try {
			ad = contentApiClient.findAdByCode(adCode);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("find failed", ex);
		}
		
		AdResponse resp = new AdResponse();
		resp.setAd(ad);
		resp.setResult(code, errMsg);
		return resp;
	}
}
