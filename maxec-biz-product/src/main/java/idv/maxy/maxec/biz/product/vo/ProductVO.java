package idv.maxy.maxec.biz.product.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductVO {
	private String id;
	private String name;
	private String sku;
	private Integer price;
	private String alias;
	private String description;
	private String brief;
	private Integer rating;
	private Integer weight;
	private Integer saleAmount;
	private String saleDate;
	private Date onsaleTime;
	private Date offsaleTime;
	
	private BrandVO brand;
	private List<ProductTagVO> tags = new ArrayList<>();
	private List<ProductCategoryVO> categories = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(Integer saleAmount) {
		this.saleAmount = saleAmount;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public BrandVO getBrand() {
		return brand;
	}
	public void setBrand(BrandVO brand) {
		this.brand = brand;
	}
	public List<ProductCategoryVO> getCategories() {
		return categories;
	}
	public List<ProductTagVO> getTags() {
		return tags;
	}
	public void setCategories(List<ProductCategoryVO> categories) {
		this.categories = categories;
	}
	public void setTags(List<ProductTagVO> tags) {
		this.tags = tags;
	}
	
	public Date getOffsaleTime() {
		return offsaleTime;
	}
	public void setOffsaleTime(Date offsaleTime) {
		this.offsaleTime = offsaleTime;
	}
	public Date getOnsaleTime() {
		return onsaleTime;
	}
	public void setOnsaleTime(Date onsaleTime) {
		this.onsaleTime = onsaleTime;
	}
	
}
