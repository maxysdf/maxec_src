package idv.maxy.maxec.app.frontend.service.impl;

import idv.maxy.maxec.biz.shopping.vo.ShowCartVO;

public interface FrontendService {
	
	/**
	 * 
	 * @param customerId
	 * @throws Exception
	 */
	public ShowCartVO getCart(String customerId) throws Exception;
	
	
}
