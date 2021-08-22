package idv.maxy.maxec.biz.search.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import idv.maxy.maxec.biz.search.model.SearchProduct;

@Repository
public interface SearchProductRepository extends BaseRepository<SearchProduct, String> {
	
}
