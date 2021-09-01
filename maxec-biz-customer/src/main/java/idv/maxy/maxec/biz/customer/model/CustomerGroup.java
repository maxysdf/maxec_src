package idv.maxy.maxec.biz.customer.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import idv.maxy.maxec.core.model.BaseManagedModel;

@Entity
@Table(name="CUSTOMER_GROUP")
public class CustomerGroup extends BaseManagedModel {
	
	/** 代碼 - 訪客 */
	public static final String CODE_GUEST = "GUEST";
	/** 代碼 - 會員 */
	public static final String CODE_MEMBER = "MEMBER";
	
	private String _name;
	private String _code;
	private Set<CustomerAttribute> customerAttributes = new LinkedHashSet<>();
	private Set<Customer> customers = new LinkedHashSet<>();
	
	@Column(name="NAME", length=50, nullable=true)
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
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customerGroup", orphanRemoval=true)
	public Set<CustomerAttribute> getCustomerAttributes() {
		return customerAttributes;
	}
	public void setCustomerAttributes(Set<CustomerAttribute> customerAttributes) {
		this.customerAttributes = customerAttributes;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customerGroup", orphanRemoval=true)
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
}
