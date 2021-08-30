package idv.maxy.maxec.biz.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.shopping.restapi.ShoppingRestApi;
import idv.maxy.maxec.biz.shopping.service.ShoppingService;
import idv.maxy.maxec.biz.shopping.vo.CartVO;

@RestController
public class ShoppingController implements ShoppingRestApi {

	@Autowired
	private ShoppingService shoppingService;
	
	@Override
	public CartVO getCart(String customerId) throws Exception {
		return shoppingService.getCart(customerId);
	}

	@Override
	public void addOrUpdateCartItem(String customerId, String productId, Integer qty) throws Exception {
		shoppingService.addOrUpdateCartItem(customerId, productId, qty);
	}

	@Override
	public void removeCartItem(String customerId, String productId) throws Exception {
		shoppingService.removeCartItem(customerId, productId);
	}

	@Override
	public void clearCart(String customerId) throws Exception {
		shoppingService.clearCart(customerId);
	}
}
