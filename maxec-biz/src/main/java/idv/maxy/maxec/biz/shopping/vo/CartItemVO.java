package idv.maxy.maxec.biz.shopping.vo;

import java.io.Serializable;

public class CartItemVO implements Serializable {
	private static final long serialVersionUID = -6082595620069745205L;
	
	private String productId;
	private Integer qty;
	private Long timestamp;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
