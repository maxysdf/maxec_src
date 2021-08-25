package idv.maxy.maxec.biz.search.vo;

import java.util.List;
import java.util.Map;

public class SearchProductParamVO {
	private List<String> keywords;
	private String category;
	private Integer minPrice; 
	private Integer maxPrice;
	private List<SearchProductTagParamVO> tags;
	private int pageNo;
	private int pageSize; 
	private String sort;
	private Boolean sortAsc;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Boolean getSortAsc() {
		return sortAsc;
	}
	public void setSortAsc(Boolean sortAsc) {
		this.sortAsc = sortAsc;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	public List<SearchProductTagParamVO> getTags() {
		return tags;
	}
	public void setTags(List<SearchProductTagParamVO> tags) {
		this.tags = tags;
	}
	
}
