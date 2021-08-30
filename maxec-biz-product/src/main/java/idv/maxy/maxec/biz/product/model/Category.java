package idv.maxy.maxec.biz.product.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import idv.maxy.maxec.core.model.BaseModel;

/**
 * 
 * @author Max Chen
 *
 */
@Entity
@Table(name="CATEGORY")
public class Category extends BaseModel {
	private String _name;
	private Integer _sort;
	private Set<ProductCategoryMap> _productCategoryMaps = new LinkedHashSet<>();
	
	@Column(name="NAME", length=200, nullable=true)
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@Column(name="SORT", nullable=true)
	public Integer getSort() {
		return _sort;
	}
	public void setSort(Integer _sort) {
		this._sort = _sort;
	}
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	public Set<ProductCategoryMap> getProductCategoryMaps() {
		return _productCategoryMaps;
	}
	public void setProductCategoryMaps(Set<ProductCategoryMap> _productCategoryMaps) {
		this._productCategoryMaps = _productCategoryMaps;
	}
}
