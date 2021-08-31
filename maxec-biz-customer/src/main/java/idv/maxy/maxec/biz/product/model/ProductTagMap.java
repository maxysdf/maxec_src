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
@Table(name="PRODUCT_TAG_MAP")
public class ProductTagMap extends BaseModel {
	private Product _product;
	private Tag _tag;
	private String _value;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	public Product getProduct() {
		return _product;
	}
	public void setProduct(Product _product) {
		this._product = _product;
	}
	
	@Column(name="VALUE", length=200, nullable=true)
	public String getValue() {
		return _value;
	}
	public void setValue(String _value) {
		this._value = _value;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="TAG_ID")
	public Tag getTag() {
		return _tag;
	}
	public void setTag(Tag _tag) {
		this._tag = _tag;
	}
}
