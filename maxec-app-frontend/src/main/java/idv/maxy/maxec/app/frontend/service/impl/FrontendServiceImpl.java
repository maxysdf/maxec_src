package idv.maxy.maxec.app.frontend.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.maxy.maxec.biz.product.restapi.ProductRestAPI;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.shopping.restapi.ShoppingRestApi;
import idv.maxy.maxec.biz.shopping.vo.CartItemVO;
import idv.maxy.maxec.biz.shopping.vo.CartVO;
import idv.maxy.maxec.biz.shopping.vo.ShowCartItemVO;
import idv.maxy.maxec.biz.shopping.vo.ShowCartVO;

@Service
public class FrontendServiceImpl implements FrontendService {
	
	@Autowired
	private ShoppingRestApi shoppingRestApi;
	
	@Autowired
	private ProductRestAPI productRestApi;
	
	/**
	 * 
	 * @param customerId
	 * @throws Exception
	 */
	public ShowCartVO getCart(String customerId) throws Exception {
		ShowCartVO scart = new ShowCartVO();
		
		CartVO cart = shoppingRestApi.getCart(customerId);
		if(cart != null) {
			List<String> productIds = cart.getItems().stream().map(CartItemVO::getProductId).collect(toList());
			
			List<ProductVO> products = productRestApi.findProductByIds(productIds);
			Map<String, ProductVO> productMap = products.stream().collect(Collectors.toMap(ProductVO::getId, p->p));
			
			// construct show cart
			int sship = 0;
			int ssubtotal = 0;
			
			for(CartItemVO cartItem : cart.getItems()) {
				String productId = cartItem.getProductId();
				ProductVO product = productMap.get(productId);
				if(product == null) { continue; }
				
				int siprice = product.getPrice() != null ? product.getPrice() : 0;
				int siqty = cartItem.getQty() != null ? cartItem.getQty() : 0;
				int simaxqty = 5;
				int sisubtotal = siprice * siqty;
				String siname = product.getName();
				String siid = product.getId();
				
				ShowCartItemVO sitem = new ShowCartItemVO();
				sitem.setProductId(siid);
				sitem.setPrice(siprice);
				sitem.setMaxQty(simaxqty);
				sitem.setName(siname);
				sitem.setQty(siqty);
				sitem.setSubtotal(sisubtotal);
				scart.getItems().add(sitem);
				
				// accumulate to cart
				ssubtotal += sisubtotal;
			}
			
			int stotal = ssubtotal + sship;
			scart.setShipFee(sship);
			scart.setSubtotal(ssubtotal);
			scart.setTotal(stotal);
		}
		
		return scart;
	}
	
}
