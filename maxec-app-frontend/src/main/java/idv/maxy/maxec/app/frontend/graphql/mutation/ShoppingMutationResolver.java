package idv.maxy.maxec.app.frontend.graphql.mutation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.maxy.maxec.app.frontend.graphql.vo.ResponseVO;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseWrapperVO;
import idv.maxy.maxec.app.frontend.service.impl.FrontendService;
import idv.maxy.maxec.biz.shopping.restapi.ShoppingRestApi;
import idv.maxy.maxec.biz.shopping.vo.ShowCartVO;

@Component
public class ShoppingMutationResolver extends MutationResolver {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingMutationResolver.class);
	
	@Autowired
	private ShoppingRestApi shoppingRestApi;
	
	@Autowired
	private FrontendService frontendService;
	
	// response types ----------------------------------------------------------------
	public static class CartResponse extends ResponseWrapperVO {
		private ShowCartVO cart;
		public ShowCartVO getCart() {
			return cart;
		}
		public void setCart(ShowCartVO cart) {
			this.cart = cart;
		}
	}
	
	@FunctionalInterface
	private interface Operation {
		void operate() throws Exception;
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public CartResponse addOrUpdateCartItem(String customerId, String productId, int qty) {
		return alterCart(customerId, () -> {
			shoppingRestApi.addOrUpdateCartItem(customerId, productId, qty);
		});
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public CartResponse removeCartItem(String customerId, String productId) {
		return alterCart(customerId, () -> {
			shoppingRestApi.removeCartItem(customerId, productId);
		});
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public CartResponse clearCart(String customerId) {
		return alterCart(customerId, () -> {
			shoppingRestApi.clearCart(customerId);
		});
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	private CartResponse alterCart(String customerId, Operation op) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		ShowCartVO scart = null;
		try {
			op.operate();
			
			// get cart
			scart = frontendService.getCart(customerId);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("search failed", ex);
		}
		
		CartResponse resp = new CartResponse();
		resp.setCart(scart);
		resp.setResult(code, errMsg);
		return resp;
	}
}
