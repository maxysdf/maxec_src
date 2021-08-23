package idv.maxy.maxec.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@MappedSuperclass
public class BaseManagedModel extends BaseModel {
	private String _createUserId;
	private Date _createTime;
	private String _updateUserId;
	private Date _updateTime;
	private Boolean _isDeleted;
	
	@CreatedBy
	@Column(name="CREATE_USER_ID", nullable=true)
	public String getCreateUserId() {
		return _createUserId;
	}
	public void setCreateUserId(String _createUserId) {
		this._createUserId = _createUserId;
	}
	
	@CreationTimestamp
	@Column(name="CREATE_TIME", nullable=true)
	public Date getCreateTime() {
		return _createTime;
	}
	public void setCreateTime(Date _createTime) {
		this._createTime = _createTime;
	}
	
	@LastModifiedBy
	@Column(name="UPDATE_USER_ID", nullable=true)
	public String get_updateUserId() {
		return _updateUserId;
	}
	public void set_updateUserId(String _updateUserId) {
		this._updateUserId = _updateUserId;
	}
	
	@UpdateTimestamp
	@Column(name="UPDATE_TIME", nullable=true)
	public Date getUpdateTime() {
		return _updateTime;
	}
	public void setUpdateTime(Date _updateTime) {
		this._updateTime = _updateTime;
	}
	
	@Type(type="yes_no")
	@Column(name="IS_DELETED", nullable=true)
	public Boolean get_isDeleted() {
		return _isDeleted;
	}
	public void set_isDeleted(Boolean _isDeleted) {
		this._isDeleted = _isDeleted;
	}
}
