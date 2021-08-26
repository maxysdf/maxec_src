package idv.maxy.maxec.biz.shopping.restapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import idv.maxy.maxec.biz.shopping.vo.CartVO;
import idv.maxy.maxec.biz.shopping.vo.ShowCartVO;

public interface ShoppingRestApi {

	@GetMapping("/cart")
	public CartVO getCart(@RequestParam("customerId") String customerId) throws Exception;
	
	@PostMapping("/cart")
	public void addOrUpdateCartItem(@RequestParam("customerId") String customerId, 
			@RequestParam("productId") String productId, 
			@RequestParam("qty") Integer qty) throws Exception;
	
	@DeleteMapping("/cart/item")
	public void removeCartItem(@RequestParam("customerId") String customerId, 
			@RequestParam("productId") String productId) throws Exception;
	
	@DeleteMapping("/cart/items")
	public void clearCart(@RequestParam("customerId") String customerId) throws Exception;
	
}
