package idv.maxy.maxec.biz.product.model;

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
	private Set<Product> _products;
	
	@Column(name="NAME", length=200, nullable=true)
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="brand", orphanRemoval=true)
	public Set<Product> getProducts() {
		return _products;
	}
	
	public void setProducts(Set<Product> _products) {
		this._products = _products;
	}
}
