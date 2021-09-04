package idv.maxy.maxec.biz.product.vo;

import java.util.List;

public class BasePageParamVO {
	private List<String> keywords;
	private int pageNo;
	private int pageSize; 
	private String sort;
	private Boolean sortAsc;
	

	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
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
}
