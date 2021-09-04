package idv.maxy.maxec.biz.content.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import idv.maxy.maxec.core.model.BaseManagedModel;

@Entity
@Table(name="AD")
public class Ad extends BaseManagedModel {
	
	private String _name;
	private String _code;
	private Date _startTime;
	private Date _endTime;
	private Set<AdItem> _adItems = new LinkedHashSet<>();
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME", nullable=true)
	public Date getStartTime() {
		return _startTime;
	}
	public void setStartTime(Date _startTime) {
		this._startTime = _startTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME", nullable=true)
	public Date getEndTime() {
		return _endTime;
	}
	public void setEndTime(Date _endTime) {
		this._endTime = _endTime;
	}
	
	@OneToMany(mappedBy="ad", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	@OrderBy("SORT ASC")
	public Set<AdItem> getAdItems() {
		return _adItems;
	}
	public void setAdItems(Set<AdItem> adItems) {
		this._adItems = adItems;
	}
	
}
