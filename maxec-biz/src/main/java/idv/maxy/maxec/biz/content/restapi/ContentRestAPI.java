package idv.maxy.maxec.biz.content.restapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import idv.maxy.maxec.biz.content.vo.AdVO;

/**
 * 
 * @author Max Chen
 *
 */
public interface ContentRestAPI {
	@DeleteMapping("/content")
	public void deleteContent(@RequestParam("path") String path) throws Exception;
	
	@GetMapping("/content")
	public AdVO findAdByCode(@RequestParam("content") String code);
}
