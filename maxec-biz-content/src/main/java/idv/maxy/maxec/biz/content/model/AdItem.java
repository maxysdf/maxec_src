package idv.maxy.maxec.biz.content.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import idv.maxy.maxec.core.model.BaseModel;

@Entity
@Table(name="AD_ITEM")
public class AdItem extends BaseModel {
	
	private String _imagePath;
	private String _imageAlt;
	private String _imageLink;
	private Boolean _isOpenNew;
	private Integer _sort;
	private Ad ad;
	
	@Column(name="IMAGE_PATH", length=200, nullable=true)
	public String getImagePath() {
		return _imagePath;
	}
	public void setImagePath(String _imagePath) {
		this._imagePath = _imagePath;
	}
	
	@Column(name="IMAGE_ALT", length=100, nullable=true)
	public String getImageAlt() {
		return _imageAlt;
	}
	public void setImageAlt(String _imageAlt) {
		this._imageAlt = _imageAlt;
	}
	
	@Column(name="IMAGE_LINK", length=500, nullable=true)
	public String getImageLink() {
		return _imageLink;
	}
	public void setImageLink(String _imageLink) {
		this._imageLink = _imageLink;
	}
	
	@Type(type="yes_no")
	@Column(name="IS_OPEN_NEW", length=1, nullable=true)
	public Boolean getIsOpenNew() {
		return _isOpenNew;
	}
	public void setIsOpenNew(Boolean _isOpenNew) {
		this._isOpenNew = _isOpenNew;
	}
	
	@Column(name="SORT", nullable=true)
	public Integer getSort() {
		return _sort;
	}
	public void setSort(Integer _sort) {
		this._sort = _sort;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="AD_ID")
	public Ad getAd() {
		return ad;
	}
	public void setAd(Ad ad) {
		this.ad = ad;
	}
}
