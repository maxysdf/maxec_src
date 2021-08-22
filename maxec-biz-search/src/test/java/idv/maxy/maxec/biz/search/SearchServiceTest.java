package idv.maxy.maxec.biz.search;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import idv.maxy.maxec.biz.search.service.SearchService;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@ActiveProfiles("search")
public class SearchServiceTest {
	
	@Autowired
	private SearchService searchService;
	
	@Test
	public void testSearchProductByKeyword() {
		searchService.searchProductByKeyword(Arrays.asList("xxx", "yyy"));
	}
	
	@Test
	public void testSaveSearchProduct() {
		searchService.saveSearchProduct();
	}
	
	
}
