package idv.maxy.maxec.biz.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.customer.restapi.CustomerRestApi;
import idv.maxy.maxec.biz.customer.service.CustomerService;
import idv.maxy.maxec.biz.customer.vo.RegisterParamVO;

@RestController
public class CustomerController implements CustomerRestApi {

	@Autowired
	private CustomerService customerService;

	@Override
	public void register(RegisterParamVO param) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deregister(String account, String id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
