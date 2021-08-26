package idv.maxy.maxec.biz.shopping.vo;

public class ShowCartItemVO {
	private String productId;
	private String name;
	private Integer price;
	private Integer qty;
	private Integer maxQty;
	private Integer subtotal;
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getMaxQty() {
		return maxQty;
	}
	public void setMaxQty(Integer maxQty) {
		this.maxQty = maxQty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
