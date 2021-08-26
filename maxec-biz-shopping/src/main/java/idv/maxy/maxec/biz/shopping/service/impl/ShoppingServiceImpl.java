package idv.maxy.maxec.biz.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.maxy.maxec.biz.shopping.dao.CartDao;
import idv.maxy.maxec.biz.shopping.service.ShoppingService;
import idv.maxy.maxec.biz.shopping.vo.CartItemVO;
import idv.maxy.maxec.biz.shopping.vo.CartVO;
import idv.maxy.maxec.core.util.StringUtil;

/**
 * 
 * @author Max Chen
 *
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {
	
	@Autowired
	private CartDao cartDao;

	@Override
	public void addOrUpdateCartItem(String customerId, String productId, 
			Integer qty) throws Exception {
		if(StringUtil.isEmptyOrNull(productId)) { throw new Exception("no product"); }
		if(qty == null || qty < 1) { throw new Exception("no qty"); }
		
		// get cart
		CartVO cart = cartDao.getCart(customerId);
		if(cart == null) { 
			cart = new CartVO();
			cart.setCustomerId(customerId);
		}
		
		// update cart item
		CartItemVO item = cart.getItems().stream()
			.filter(ci->productId.equals(ci.getProductId()))
			.findFirst().orElse(null);
		
		if(item == null) { 
			item = new CartItemVO();
			cart.getItems().add(item);
		}
		item.setProductId(productId);
		item.setQty(qty);
		
		// save
		cartDao.saveCart(customerId, cart);
	}
	
	@Override
	public void clearCart(String customerId) throws Exception {
		CartVO cart = cartDao.getCart(customerId);
		if(cart == null) { return; }
		
		cart.getItems().clear();
		
		// save
		cartDao.saveCart(customerId, cart);
	}
	
	@Override
	public void removeCartItem(String customerId, String productId) throws Exception {
		if(StringUtil.isEmptyOrNull(productId)) { throw new Exception("no product"); }
		
		CartVO cart = cartDao.getCart(customerId);
		if(cart == null) { throw new Exception("no cart"); }
		
		cart.getItems().removeIf(ci->productId.equals(ci.getProductId()));
		
		// save
		cartDao.saveCart(customerId, cart);
	}
	
	@Override
	public CartVO getCart(String customerId) throws Exception {
		return cartDao.getCart(customerId);
	}
}
