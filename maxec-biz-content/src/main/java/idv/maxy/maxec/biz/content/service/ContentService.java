package idv.maxy.maxec.biz.content.service;

import java.io.InputStream;

import idv.maxy.maxec.biz.content.vo.AdVO;

/**
 * 
 * @author Max Chen
 *
 */
public interface ContentService {
	
	/**
	 * 
	 * @param f
	 * @param path
	 */
	public void uploadFile(InputStream f, String path) throws Exception ;
	
	/**
	 * 
	 * @param path
	 * @throws Exception
	 */
	public void deleteContent(String path) throws Exception ;
	
	
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public AdVO findAdByCode(String code);
	
	
	
	
	
}
