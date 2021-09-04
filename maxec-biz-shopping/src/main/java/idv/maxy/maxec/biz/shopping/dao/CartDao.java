package idv.maxy.maxec.biz.shopping.dao;

import idv.maxy.maxec.biz.shopping.vo.CartVO;

/**
 * 
 * @author Max Chen
 *
 */
public interface CartDao {
	
	/**
	 * 
	 * @param customerId
	 * @param cart
	 * @throws Exception
	 */
	public void saveCart(String customerId, CartVO cart) throws Exception;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	public CartVO getCart(String customerId) throws Exception;
}
