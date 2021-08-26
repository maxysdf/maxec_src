package idv.maxy.maxec.biz.shopping.vo;

import java.util.ArrayList;
import java.util.List;

public class ShowCartVO {
	private Integer subtotal;
	private Integer shipFee;
	private Integer total;
	private List<ShowCartItemVO> items = new ArrayList<>();
	
	public Integer getShipFee() {
		return shipFee;
	}
	public void setShipFee(Integer shipFee) {
		this.shipFee = shipFee;
	}
	public Integer getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<ShowCartItemVO> getItems() {
		return items;
	}
	public void setItems(List<ShowCartItemVO> items) {
		this.items = items;
	}
}
