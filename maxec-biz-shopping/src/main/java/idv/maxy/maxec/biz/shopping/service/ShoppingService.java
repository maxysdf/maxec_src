package idv.maxy.maxec.biz.shopping.service;

import idv.maxy.maxec.biz.shopping.vo.CartVO;

/**
 * 
 * @author Max Chen
 *
 */
public interface ShoppingService {
	
	/**
	 * 
	 * @param customerId
	 * @param productId
	 * @param qty
	 */
	public void addOrUpdateCartItem(String customerId, String productId, 
			Integer qty) throws Exception;
	
	
	/**
	 * 
	 * @param customerId
	 * @param productId
	 * @param qty
	 */
	public void removeCartItem(String customerId, String productId) throws Exception;
	
	/**
	 * 
	 * @param customerId
	 * @param productId
	 * @param qty
	 */
	public void clearCart(String customerId) throws Exception;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	public CartVO getCart(String customerId) throws Exception;
}
