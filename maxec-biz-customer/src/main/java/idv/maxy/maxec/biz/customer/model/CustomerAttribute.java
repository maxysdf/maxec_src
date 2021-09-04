package idv.maxy.maxec.biz.customer.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import idv.maxy.maxec.core.model.BaseManagedModel;

@Entity
@Table(name="CUSTOMER_ATTRIBUTE")
public class CustomerAttribute extends BaseManagedModel {
	private String _name;
	private String _displayName;
	private String _code;
	private CustomerGroup customerGroup;
	private Set<CustomerAttributeMap> customerAttributeMaps = new LinkedHashSet<>();
	
	@Column(name="NAME", length=50, nullable=true)
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@Column(name="DISPLAY_NAME", length=100, nullable=true)
	public String getDisplayName() {
		return _displayName;
	}
	public void setDisplayName(String _displayName) {
		this._displayName = _displayName;
	}
	
	@Column(name="CODE", length=50, nullable=true)
	public String getCode() {
		return _code;
	}
	public void setCode(String _code) {
		this._code = _code;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_GROUP_ID")
	public CustomerGroup getCustomerGroup() {
		return customerGroup;
	}
	public void setCustomerGroup(CustomerGroup customerGroup) {
		this.customerGroup = customerGroup;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer", orphanRemoval=true)
	public Set<CustomerAttributeMap> getCustomerAttributeMaps() {
		return customerAttributeMaps;
	}
	public void setCustomerAttributeMaps(Set<CustomerAttributeMap> customerAttributeMaps) {
		this.customerAttributeMaps = customerAttributeMaps;
	}
}
