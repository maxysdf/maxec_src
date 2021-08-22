package idv.maxy.maxec.biz.search.service;

import java.util.List;

import org.springframework.data.domain.Page;


/**
 * 
 * @author Max Chen
 *
 */
public interface SearchService {
	public void searchProductByKeyword(List<String> keywords);
	public void saveSearchProduct();

}
