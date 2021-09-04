package idv.maxy.maxec.biz.customer.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import idv.maxy.maxec.core.model.BaseManagedModel;

@Entity
@Table(
	name="CUSTOMER",
	indexes= {
		@Index(unique=true, columnList="username"),
		@Index(unique=true, columnList="email")
	}
)
public class Customer extends BaseManagedModel {
	
	/** 狀態 - 新增 */
	public static final String STATUS_NEW = "NEW";
	/** 狀態 - 啟用 */
	public static final String STATUS_ENABLED = "ENABLED";
	/** 狀態 - 鎖定 */
	public static final String STATUS_LOCKED = "LOCKED";
	/** 狀態 - 停用 */
	public static final String STATUS_DISABLED = "DISABLED";
	
	private String _name;
	private String _email;
	private String _username;
	private String _password;
	private String _status;
	private CustomerGroup customerGroup;
	private Set<CustomerAttributeMap> customerAttributeMaps = new LinkedHashSet<>();
	
	@Column(name="NAME", length=50, nullable=true)
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@Column(name="EMAIL", length=100, nullable=true)
	public String getEmail() {
		return _email;
	}
	public void setEmail(String _email) {
		this._email = _email;
	}
	
	@Column(name="USERNAME", length=50, nullable=true)
	public String getUsername() {
		return _username;
	}
	public void setUsername(String _username) {
		this._username = _username;
	}
	
	@Column(name="PASSWORD", length=100, nullable=true)
	public String getPassword() {
		return _password;
	}
	public void setPassword(String _password) {
		this._password = _password;
	}
	
	@Column(name="STATUS", length=20, nullable=true)
	public String getStatus() {
		return _status;
	}
	public void setStatus(String _status) {
		this._status = _status;
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
