package idv.maxy.maxec.biz.customer.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idv.maxy.maxec.core.model.BaseModel;

@Entity
@Table(name="CUSTOMER_ATTRIBUTE_MAP")
public class CustomerAttributeMap extends BaseModel {
	
	private Customer customer;
	private CustomerAttribute customerAttribute;
	private String _value;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ATTRIBUTE_ID")
	public CustomerAttribute getCustomerAttribute() {
		return customerAttribute;
	}
	public void setCustomerAttribute(CustomerAttribute customerAttribute) {
		this.customerAttribute = customerAttribute;
	}
	
	@Column(name="VALUE", length=100, nullable=true)
	public String getValue() {
		return _value;
	}
	public void setValue(String _value) {
		this._value = _value;
	}
}
