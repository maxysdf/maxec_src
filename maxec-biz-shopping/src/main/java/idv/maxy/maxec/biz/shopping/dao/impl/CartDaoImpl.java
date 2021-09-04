package idv.maxy.maxec.biz.shopping.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.maxy.maxec.biz.shopping.dao.CartDao;
import idv.maxy.maxec.biz.shopping.vo.CartVO;

@Repository
public class CartDaoImpl implements CartDao {
	private static final String KEY_CART = "cart";
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String, String> cartOper;
	
	/**
	 * 
	 */
	public void saveCart(String customerId, CartVO cart) throws Exception {
		String val = new ObjectMapper().writeValueAsString(cart);
		cartOper.put(KEY_CART, customerId, val);
	}
	
	/**
	 * 
	 */
	public CartVO getCart(String customerId) throws Exception {
		String val = cartOper.get(KEY_CART, customerId);
		if(val == null) { return null; }
		
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CartVO o = om.readValue(val, CartVO.class);
		return o;
	}
}
