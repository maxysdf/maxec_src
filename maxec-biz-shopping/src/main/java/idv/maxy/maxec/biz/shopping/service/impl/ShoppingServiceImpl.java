package idv.maxy.maxec.biz.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.maxy.maxec.biz.shopping.service.ShoppingService;
import idv.maxy.maxec.biz.shopping.vo.CartVO;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	private static final String KEY_CART = "cart";
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String, String> cartOper;
	
	public void saveCart(String customerId, CartVO cart) throws Exception {
		String val = new ObjectMapper().writeValueAsString(cart);
		cartOper.put(KEY_CART, customerId, val);
	}
	
	public CartVO readCart(String customerId) throws Exception  {
		String val = cartOper.get(KEY_CART, customerId);
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CartVO o = om.readValue(val, CartVO.class);
		return o;
	}
	
	
}
