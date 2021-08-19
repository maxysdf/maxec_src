package idv.maxy.maxec.biz.product.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idv.maxy.maxec.core.model.BaseModel;

/**
 * 
 * @author Max Chen
 *
 */
@Entity
@Table(name="PRODUCT")
public class Product extends BaseModel {
	private String _name;
	private Integer _price;
	private String _alias;
	private Brand _brand;
	
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
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="BRAND_ID")
	public Brand getBrand() {
		return _brand;
	}
	
	public void setBrand(Brand _brand) {
		this._brand = _brand;
	}
	
}
