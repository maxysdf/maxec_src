package idv.maxy.maxec.biz.shopping.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartVO implements Serializable {
	private static final long serialVersionUID = -7347843713207397650L;
	
	private String customerId;
	private String couponId;
	private List<CartItemVO> items = new ArrayList<>();
	
	public List<CartItemVO> getItems() {
		return items;
	}
	public void setItems(List<CartItemVO> items) {
		this.items = items;
	}
	
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
