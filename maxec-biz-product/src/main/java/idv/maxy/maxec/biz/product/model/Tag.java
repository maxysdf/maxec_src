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
@Table(name="TAG")
public class Tag extends BaseModel {
	
	/** 標籤類別 - 廠牌 */
	public static final String TAG_TYPE_BRAND = "BRAND";
	/** 標籤類別 - 目錄 */
	public static final String TAG_TYPE_CATEGORY = "CATEGORY";
	/** 標籤類別 - 尺吋 */
	public static final String TAG_TYPE_SIZE  = "SIZE";
	/** 標籤類別 - 顏色 */
	public static final String TAG_TYPE_COLOR = "COLOR";
	/** 標籤類別 - 一般標籤 */
	public static final String TAG_TYPE_TAG   = "TAG";
	
	private String _type;
	private String _name;
	private String _code;
	private String _value;
	private Integer _sort;
	private Set<ProductTagMap> _productTagMaps = new LinkedHashSet<>();
	
	@Column(name="TYPE", length=20, nullable=false)
	public String getType() {
		return _type;
	}
	public void setType(String _type) {
		this._type = _type;
	}
	
	@Column(name="NAME", length=200, nullable=true)
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@Column(name="CODE", length=50, nullable=false)
	public String getCode() {
		return _code;
	}
	public void setCode(String _code) {
		this._code = _code;
	}
	
	@Column(name="VALUE", length=200, nullable=true)
	public String getValue() {
		return _value;
	}
	public void setValue(String _value) {
		this._value = _value;
	}
	
	@Column(name="SORT", nullable=true)
	public Integer getSort() {
		return _sort;
	}
	public void setSort(Integer _sort) {
		this._sort = _sort;
	}
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="tag", orphanRemoval=true)
	public Set<ProductTagMap> getProductTagMaps() {
		return _productTagMaps;
	}
	
	public void setProductTagMaps(Set<ProductTagMap> _productTagMaps) {
		this._productTagMaps = _productTagMaps;
	}
}
