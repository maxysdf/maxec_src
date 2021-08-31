package idv.maxy.maxec.biz.customer.restapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import idv.maxy.maxec.biz.customer.vo.RegisterParamVO;

public interface CustomerRestApi {
	
	@PutMapping("/customer")
	public void register(@RequestBody RegisterParamVO param) throws Exception;
	
	@DeleteMapping("/customer")
	public void deregister(@RequestParam("account") String account, @RequestParam("id") String id) throws Exception;
	
	
}
