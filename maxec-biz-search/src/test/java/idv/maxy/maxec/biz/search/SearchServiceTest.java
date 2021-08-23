package idv.maxy.maxec.biz.search;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import idv.maxy.maxec.biz.search.model.SearchProduct;
import idv.maxy.maxec.biz.search.service.SearchService;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@ActiveProfiles("search")
public class SearchServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(SearchServiceTest.class);
	
	
	@Autowired
	private SearchService searchService;
	
	//@Test
	public void testSearchProductByKeyword() {
		searchService.searchProductByKeyword(Arrays.asList("xxx", "yyy"));
	}
	
	//@Test
	public void testSaveSearchProduct() {
		for(int i = 0; i < 100; i++) searchService.saveSearchProduct();
	}
	
	@Test
	public void testProductSearch() {
		List<String> keywords = Arrays.asList("xxx", "zzz", "prod");
		Integer minPrice = null;
		Integer maxPrice = 13000;
		
		Map<String, List<String>> tagTypeCodes = new LinkedHashMap<>();
		tagTypeCodes.put("SIZE", Arrays.asList("SIZE::null::M"));
		
		Integer pageNo = 1;
		Integer pageSize = 10;
		
		String sort = SearchProduct.SORT_PRICE;
		boolean sortAsc = false;
		
		SearchPage<SearchProduct> page = searchService.searchProductForList(
				keywords, minPrice, maxPrice, tagTypeCodes, 
				pageNo, pageSize, sort, sortAsc);
		
		logger.info("search ---------");
		logger.info("  keywords: {}", keywords);
		logger.info("  price   : {} ~ {}", minPrice, maxPrice);
		logger.info("  sort    : {} {}", sort, sortAsc ? "ASC":"DESC");
		logger.info("  tags    : {}", tagTypeCodes);
		
		logger.info("result page:  totalhit: {}, totalpage: {}", page.getTotalElements(), page.getTotalPages());
		page.forEach(sh -> {
			logger.info("result: id:{} ", sh.getId());	
		});
	}
	
	
	
	
	
	
	
	
	
	
}
