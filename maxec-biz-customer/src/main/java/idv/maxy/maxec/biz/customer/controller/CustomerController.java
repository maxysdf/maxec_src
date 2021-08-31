package idv.maxy.maxec.biz.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.customer.restapi.CustomerRestApi;
import idv.maxy.maxec.biz.customer.service.CustomerService;

@RestController
public class CustomerController implements CustomerRestApi {

	@Autowired
	private CustomerService customerService;

}
