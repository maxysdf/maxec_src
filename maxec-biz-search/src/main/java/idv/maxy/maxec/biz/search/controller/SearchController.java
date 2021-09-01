package idv.maxy.maxec.biz.search.controller;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.search.model.SearchProduct;
import idv.maxy.maxec.biz.search.restapi.SearchRestAPI;
import idv.maxy.maxec.biz.search.service.SearchService;

import idv.maxy.maxec.biz.search.vo.SearchProductParamVO;
import idv.maxy.maxec.biz.search.vo.SearchProductResultPage;
import idv.maxy.maxec.biz.search.vo.SearchProductResultVO;
import idv.maxy.maxec.biz.search.vo.SearchProductTagParamVO;
import idv.maxy.maxec.biz.search.vo.SearchProductVO;
import idv.maxy.maxec.biz.vo.BasePage;
import idv.maxy.maxec.biz.vo.BasePageable;

/**
 * 
 * @author Max Chen
 *
 */
@RestController
public class SearchController implements SearchRestAPI {

	@Autowired
	private SearchService searchService;
	
	/**
	 * @param in
	 */
	public SearchProductResultPage searchProductForList(@RequestBody SearchProductParamVO in) throws Exception {
		List<String> keywords = in.getKeywords();
		Integer minPrice = in.getMinPrice();
		Integer maxPrice = in.getMaxPrice();
		int pageNo = in.getPageNo();
		int pageSize = in.getPageSize();
		String sort = in.getSort();
		boolean sortAsc = Boolean.TRUE.equals(in.getSortAsc());

		Map<String, List<String>> tagTypeIds = new LinkedHashMap<String, List<String>>();
		List<SearchProductTagParamVO> inTags = in.getTags();
		if(inTags != null) {
			for(SearchProductTagParamVO inTag : inTags) {
				tagTypeIds.putIfAbsent(inTag.getType(), new ArrayList<>());
				tagTypeIds.get(inTag.getType()).add(String.format("%s::%s", inTag.getType(), inTag.getId()));
			}
		}
		
		SearchPage<SearchProduct> spage = searchService.searchProductForList(
				keywords, minPrice, maxPrice, tagTypeIds, pageNo, pageSize, sort, sortAsc);

		List<SearchProductResultVO> list = spage.getContent().stream().map(s -> {
			SearchProductResultVO v = new SearchProductResultVO();
			v.setId(s.getId());
			return v;
		}).collect(toList());
		
		SearchProductResultPage page = new SearchProductResultPage(list, pageSize, pageNo, spage.getTotalElements());
		
		//page.copyPageProps(spage);
		
		return page;
	}

	
	/**
	 * @param in
	 */
	public BasePageable searchProductForList2(@RequestBody SearchProductParamVO in) throws Exception {
		List<String> keywords = in.getKeywords();
		Integer minPrice = in.getMinPrice();
		Integer maxPrice = in.getMaxPrice();
		int pageNo = in.getPageNo();
		int pageSize = in.getPageSize();
		String sort = in.getSort();
		boolean sortAsc = Boolean.TRUE.equals(in.getSortAsc());

		Map<String, List<String>> tagTypeIds = new LinkedHashMap<String, List<String>>();
		List<SearchProductTagParamVO> inTags = in.getTags();
		if(inTags != null) {
			for(SearchProductTagParamVO inTag : inTags) {
				tagTypeIds.putIfAbsent(inTag.getType(), new ArrayList<>());
				tagTypeIds.get(inTag.getType()).add(String.format("%s::%s", inTag.getType(), inTag.getId()));
			}
		}
		
		SearchPage<SearchProduct> spage = searchService.searchProductForList(
				keywords, minPrice, maxPrice, tagTypeIds, pageNo, pageSize, sort, sortAsc);

		BasePageable page = null;//new BasePage<>(spage);
		
//		
//		
//		SearchProductResultPage page = new SearchProductResultPage(spage.map(s-> {
//			SearchProductResultVO p = new SearchProductResultVO();
//			p.setId(s.getId());
//			return p;
//		}));
		
		return page;
	}


	@Override
	public void saveAllSearchProduct(List<SearchProductVO> list, long ts) {
		
		List<SearchProduct> mlist = list.stream().map(v -> {
			if(v == null) { return null; }
			SearchProduct m = new SearchProduct();
			m.setId(v.getId());
			m.setBrief(v.getBrief());
			m.setDescription(v.getDescription());
			m.setName(v.getName());
			m.setPrice(v.getPrice());
			m.setRating(v.getRating());
			m.setSaleAmount(v.getSaleAmount());
			m.setSaleDate(v.getSaleDate());
			m.setSku(v.getSku());
			m.setTag(v.getTag());
			m.setTimestamp(v.getTimestamp());
			m.setWeight(v.getWeight());
			return m;
		}).collect(Collectors.toList());
		
		searchService.saveAllSearchProduct(mlist, ts);
	}
	
}
