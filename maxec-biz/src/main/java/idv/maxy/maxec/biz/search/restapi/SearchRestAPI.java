package idv.maxy.maxec.biz.search.restapi;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import idv.maxy.maxec.biz.search.vo.SearchProductParamVO;
import idv.maxy.maxec.biz.search.vo.SearchProductResultPage;
import idv.maxy.maxec.biz.search.vo.SearchProductVO;
import idv.maxy.maxec.biz.vo.BasePageable;

public interface SearchRestAPI {
	
	@PostMapping("/product")
	public SearchProductResultPage searchProductForList(@RequestBody SearchProductParamVO in) throws Exception;
	
	@PostMapping("/product2")
	public BasePageable searchProductForList2(@RequestBody SearchProductParamVO in) throws Exception;
	
	@PutMapping("/products")
	public void saveAllSearchProduct(List<SearchProductVO> list, long ts);
	
}
