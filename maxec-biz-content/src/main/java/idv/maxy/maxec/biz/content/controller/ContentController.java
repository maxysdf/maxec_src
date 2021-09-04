package idv.maxy.maxec.biz.content.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.content.restapi.ContentRestAPI;
import idv.maxy.maxec.biz.content.service.ContentService;
import idv.maxy.maxec.biz.content.vo.AdVO;

/**
 * 
 * @author Max Chen
 *
 */
@RestController
public class ContentController implements ContentRestAPI {

	@Autowired
	private ContentService contentService;
	
	@Override
	public void deleteContent(String path) throws Exception {
		contentService.deleteContent(path);
	}

	@Override
	public AdVO findAdByCode(String code) {
		return contentService.findAdByCode(code);
	}
}
