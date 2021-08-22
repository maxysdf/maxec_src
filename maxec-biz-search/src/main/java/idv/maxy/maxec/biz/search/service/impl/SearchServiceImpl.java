package idv.maxy.maxec.biz.search.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.termsQuery;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import idv.maxy.maxec.biz.search.model.SearchProduct;
import idv.maxy.maxec.biz.search.repository.SearchProductRepository;
import idv.maxy.maxec.biz.search.service.SearchService;

/**
 * 
 * @author Max Chen
 *
 */
@Service
public class SearchServiceImpl implements SearchService {
	private final static Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	
	@Autowired
	private SearchProductRepository productRepository;

	@Autowired
	private ElasticsearchOperations esOper;
	
	/**
	 * 
	 * @param keywords
	 */
	public void searchProductByKeyword(List<String> keywords) {
		Query qry = new NativeSearchQueryBuilder()
				.withQuery(termsQuery("name", keywords))
				.build();
		
		SearchHits<SearchProduct> hits = esOper.search(qry, SearchProduct.class);
		hits.map(h-> h.getContent())
			.forEach(h -> { logger.info("find p: #{} / {}", h.getId(), h.getName() ); });
	}
	
	
	public void saveSearchProduct() {
		SearchProduct p = new SearchProduct();
		p.setId(UUID.randomUUID().toString());
		p.setName("test prod");
		p.setPrice(12000);
		p.setSku("sku1100");
		p.setRating(45);
		p.setBrief("Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor");
		p.setDescription("" + 
				"                                                <h5>Introduction</h5>" + 
				"                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do" + 
				"                                                    eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim" + 
				"                                                    ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut" + 
				"                                                    aliquip ex ea commodo consequat. Duis aute irure dolor in </p>" + 
				"                                                <h5>Features</h5>" + 
				"                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do" + 
				"                                                    eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim" + 
				"                                                    ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut" + 
				"                                                    aliquip ex ea commodo consequat. Duis aute irure dolor in </p>" + 
				"                                            ");
		p.setTimestamp(System.currentTimeMillis());
		
		p.tag("BRAND", "uniqlo", null)
		 .tag("SIZE" , null    , "M")
		 .tag("TAG"  , "coat"  , null)
		 .tag("COLOR", "red"   , null)
		 .tag("CATEGORY", "men", null)
		;
		
		
		
		esOper.save(p);
		
	}
	
	
	
}
