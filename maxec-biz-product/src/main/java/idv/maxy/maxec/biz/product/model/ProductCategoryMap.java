package idv.maxy.maxec.biz.product.model;

import javax.persistence.CascadeType;
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
@Table(name="PRODUCT_CATEGORY_MAP")
public class ProductCategoryMap extends BaseModel {
	private Product _product;
	private Category _category;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	public Product getProduct() {
		return _product;
	}
	public void setProduct(Product _product) {
		this._product = _product;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORY_ID")
	public Category getCategory() {
		return _category;
	}
	public void setCategory(Category _category) {
		this._category = _category;
	}
}
