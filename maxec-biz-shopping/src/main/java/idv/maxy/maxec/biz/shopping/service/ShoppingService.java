package idv.maxy.maxec.biz.shopping.service;

import idv.maxy.maxec.biz.shopping.vo.CartVO;

public interface ShoppingService {
	
	public void saveCart(String customerId, CartVO cart) throws Exception ;
	
	public CartVO readCart(String customerId) throws Exception ;
}
