package idv.maxy.maxec.biz.search.vo;

import java.util.ArrayList;
import java.util.List;

public class SearchProductParam {
	
	private String categoryId;
	private List<String> brandIds;
	private Integer minPrice;
	private Integer maxPrice;
	private List<SearchProductTagParam> tags = new ArrayList<>();
	
	// derived methods ---------------------------------------
	public static SearchProductParam create() {
		return new SearchProductParam();
	}
	
	public SearchProductParam category(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	public SearchProductParam brands(List<String> brandIds) {
		this.brandIds = brandIds;
		return this;
	}
	
	public SearchProductParam priceRange(Integer min, Integer max) {
		this.minPrice = min;
		this.maxPrice = max;
		return this;
	}
	
	public SearchProductParam tag(String type, String code, String value) {
		SearchProductTagParam tag = new SearchProductTagParam();
		tag.setType(type);
		tag.setCode(code);
		tag.setValue(value);
		this.tags.add(tag);
		return this;
	}

	// getter / setters ---------------------------------------
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<String> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<String> brandIds) {
		this.brandIds = brandIds;
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

	public List<SearchProductTagParam> getTags() {
		return tags;
	}

	public void setTags(List<SearchProductTagParam> tags) {
		this.tags = tags;
	}

	
	

	
}
