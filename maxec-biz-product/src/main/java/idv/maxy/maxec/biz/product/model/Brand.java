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
@Table(name="BRAND")
public class Brand extends BaseModel {
	private String _name;
	private String _code;
	private Integer _sort;
	private Set<Product> _products = new LinkedHashSet<>();
	
	@Column(name="NAME", length=200, nullable=true)
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@Column(name="CODE", length=50, nullable=true)
	public String getCode() {
		return _code;
	}
	public void setCode(String _code) {
		this._code = _code;
	}
	
	@Column(name="SORT", nullable=true)
	public Integer getSort() {
		return _sort;
	}
	public void setSort(Integer _sort) {
		this._sort = _sort;
	}
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="brand", orphanRemoval=true)
	public Set<Product> getProducts() {
		return _products;
	}
	
	public void setProducts(Set<Product> _products) {
		this._products = _products;
	}
}
