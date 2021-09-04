package idv.maxy.maxec.app.frontend.graphql.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.maxy.maxec.app.frontend.apiclient.CustomerApiClient;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseVO;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseWrapperVO;
import idv.maxy.maxec.biz.customer.vo.CustomerVO;

@Component
public class CustomerQueryResolver extends QueryResolver {
	
	@Autowired
	private CustomerApiClient customerApiClient;
	
	// response types ----------------------------------------------------------------
	public static class CustomerResponse extends ResponseWrapperVO {
		private CustomerVO customer;
		public CustomerVO getCustomer() {
			return customer;
		}
		public void setCustomer(CustomerVO customer) {
			this.customer = customer;
		}
	}
	
	// methods --------------------------------------------------------------
	public CustomerResponse login(String credential, String password) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		CustomerVO v = null;
		try {
			v = customerApiClient.login(credential, password);
			if(v == null) { throw new Exception("login failed"); }
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
		}
		
		CustomerResponse resp = new CustomerResponse();
		resp.setCustomer(v);
		resp.setResult(code, errMsg);
		return resp;
	}
}
