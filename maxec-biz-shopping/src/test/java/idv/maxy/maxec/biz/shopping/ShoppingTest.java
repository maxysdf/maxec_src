package idv.maxy.maxec.biz.shopping;

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
	
	@Test
	public void testSaveCart() throws Exception {
		CartVO c = new CartVO();
		c.setCustomerId("xxx");
		
		CartItemVO ci = new CartItemVO();
		ci.setProductId("p01");
		ci.setQty(5);
		ci.setTimestamp(System.currentTimeMillis());
		c.getItems().add(ci);
		
		shoppingService.saveCart("xxx", c);
	}
	
	@Test
	public void testReadCart() throws Exception {
		CartVO v = shoppingService.readCart("xxx");
		logger.info("v: {}", new ObjectMapper().writeValueAsString(v));
		
	}
}
