package idv.maxy.maxec.biz.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.customer.model.CustomerGroup;
import idv.maxy.maxec.biz.customer.restapi.CustomerRestApi;
import idv.maxy.maxec.biz.customer.service.CustomerService;
import idv.maxy.maxec.biz.customer.vo.CustomerVO;
import idv.maxy.maxec.biz.customer.vo.RegisterParamVO;

@RestController
public class CustomerController implements CustomerRestApi {

	@Autowired
	private CustomerService customerService;

	@Override
	public void register(RegisterParamVO param) throws Exception {
		String name = param.getName();
		String groupCode = CustomerGroup.CODE_MEMBER;
		String username = param.getUsername();
		String password = param.getPassword();
		String email = param.getEmail();
		
		customerService.register(name, groupCode, username, password, email);
	}
	
	@Override
	public void deregister(String username, String id) throws Exception {
		customerService.deregister(username, id);
	}
	
	@Override
	public CustomerVO login(String credential, String password) throws Exception {
		CustomerVO v = customerService.login(credential, password);
		return v;
	}
	
}
