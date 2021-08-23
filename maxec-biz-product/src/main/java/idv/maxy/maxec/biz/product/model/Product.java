package idv.maxy.maxec.biz.product.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import idv.maxy.maxec.core.model.BaseManagedModel;

/**
 * 
 * @author Max Chen
 *
 */
@Entity
@Table(name="PRODUCT")
public class Product extends BaseManagedModel {
	private String _name;
	private String _sku;
	private Integer _price;
	private Integer _weight;
	private Integer _rating;
	private String _brief;
	private String _description;
	private String _alias;
	private Brand _brand;
	private Set<ProductCategoryMap> _productCategoryMaps = new LinkedHashSet<>();
	private Set<ProductTagMap> _productTagMaps = new LinkedHashSet<>();
	
	@Column(name="NAME", length=200, nullable=true)
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@Column(name="PRICE", nullable=true)
	public Integer getPrice() {
		return _price;
	}
	public void setPrice(Integer _price) {
		this._price = _price;
	}
	
	@Column(name="ALIAS", length=200, nullable=true)
	public String getAlias() {
		return _alias;
	}
	public void setAlias(String _alias) {
		this._alias = _alias;
	}
	
	@Column(name="SKU", length=50, nullable=true)
	public String getSku() {
		return _sku;
	}
	public void setSku(String _sku) {
		this._sku = _sku;
	}
	
	@Column(name="WEIGHT", nullable=true)
	public Integer getWeight() {
		return _weight;
	}
	public void setWeight(Integer _weight) {
		this._weight = _weight;
	}
	
	@Column(name="RATING", nullable=true)
	public Integer getRating() {
		return _rating;
	}
	public void setRating(Integer _rating) {
		this._rating = _rating;
	}
	
	@Lob @Column(name="BRIEF", nullable=true)
	public String getBrief() {
		return _brief;
	}
	public void setBrief(String _brief) {
		this._brief = _brief;
	}
	
	@Lob @Column(name="DESCRIPTION", nullable=true)
	public String getDescription() {
		return _description;
	}
	public void setDescription(String _description) {
		this._description = _description;
	}

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="BRAND_ID")
	public Brand getBrand() {
		return _brand;
	}
	
	public void setBrand(Brand _brand) {
		this._brand = _brand;
	}
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	public Set<ProductCategoryMap> getProductCategoryMaps() {
		return _productCategoryMaps;
	}
	public void setProductCategoryMaps(Set<ProductCategoryMap> _productCategoryMaps) {
		this._productCategoryMaps = _productCategoryMaps;
	}
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	public Set<ProductTagMap> getProductTagMaps() {
		return _productTagMaps;
	}
	public void setProductTagMaps(Set<ProductTagMap> _productTagMaps) {
		this._productTagMaps = _productTagMaps;
	}
	
}
