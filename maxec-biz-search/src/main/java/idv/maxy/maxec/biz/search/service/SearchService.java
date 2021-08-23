package idv.maxy.maxec.biz.search.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.elasticsearch.core.SearchPage;

import idv.maxy.maxec.biz.search.model.SearchProduct;

/**
 * 
 * @author Max Chen
 *
 */
public interface SearchService {
	public void searchProductByKeyword(List<String> keywords);
	public void saveSearchProduct();

	public SearchPage<SearchProduct> searchProductForList(
			List<String> keywords, Integer minPrice, Integer maxPrice, 
			Map<String, List<String>> tagTypeCodes,
			int pageNo, int pageSize, String sort, boolean sortAsc);
	
	public void saveAllSearchProduct(List<SearchProduct> list, long updateTimestamp);
	
}
