package idv.maxy.maxec.biz.shopping;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;

import idv.maxy.maxec.biz.shopping.service.ShoppingService;
import idv.maxy.maxec.biz.shopping.vo.CartItemVO;
import idv.maxy.maxec.biz.shopping.vo.CartVO;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@ActiveProfiles("shopping")
public class ShoppingTest {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingTest.class);
	
	@Autowired
	private ShoppingService shoppingService;
	
	private static final String TEST_MEMBER = "__test__member__";
	
	@Test
	public void testAddCart() throws Exception {
		String productId = "p01";
		int qty = 5;
		shoppingService.addOrUpdateCartItem(TEST_MEMBER, productId, qty);
		
		CartVO cart = shoppingService.getCart(TEST_MEMBER);
		assertNotNull(cart);
		
		List<CartItemVO> cartItems = cart.getItems().stream()
				.filter(ci->productId.equals(ci.getProductId()))
				.collect(Collectors.toList());
		assertTrue(cartItems.size() == 1);
		
		Integer itemQty = cartItems.get(0).getQty();
		assertTrue(itemQty != null && itemQty == qty);
	}

	
}
