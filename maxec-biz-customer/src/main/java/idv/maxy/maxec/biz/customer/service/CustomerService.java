package idv.maxy.maxec.biz.customer.service;

import idv.maxy.maxec.biz.customer.vo.CustomerVO;

/**
 * 
 * @author Max Chen
 *
 */
public interface CustomerService {
	
	public void register(String name, String groupCode, String username, String password, String email) throws Exception;
	
	public void deregister(String username, String id) throws Exception;
	
	public CustomerVO login(String credential, String password);
	
}
