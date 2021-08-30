package idv.maxy.maxec.app.frontend.graphql.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.maxy.maxec.app.frontend.graphql.vo.ResponseVO;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseWrapperVO;
import idv.maxy.maxec.app.frontend.service.impl.FrontendService;
import idv.maxy.maxec.biz.shopping.vo.ShowCartVO;

@Component
public class ShoppingQueryResolver extends QueryResolver {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingQueryResolver.class);
	
	@Autowired
	private FrontendService frontendService;
	
	// response types ----------------------------------------------------------------
	public static class GetCartResponse extends ResponseWrapperVO {
		private ShowCartVO cart;
		public ShowCartVO getCart() {
			return cart;
		}
		public void setCart(ShowCartVO cart) {
			this.cart = cart;
		}
	}
	
	// methods --------------------------------------------------------------
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public GetCartResponse getCart(String customerId) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		ShowCartVO scart = null;
		try {
			scart = frontendService.getCart(customerId);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("search failed", ex);
		}
		
		GetCartResponse resp = new GetCartResponse();
		resp.setCart(scart);
		resp.setResult(code, errMsg);
		return resp;
	}
	
	
}
