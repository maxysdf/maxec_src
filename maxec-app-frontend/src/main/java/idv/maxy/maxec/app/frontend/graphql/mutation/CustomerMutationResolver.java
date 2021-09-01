package idv.maxy.maxec.app.frontend.graphql.mutation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.maxy.maxec.app.frontend.apiclient.CustomerApiClient;
import idv.maxy.maxec.app.frontend.graphql.vo.CustomerRegisterInputVO;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseVO;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseWrapperVO;
import idv.maxy.maxec.biz.customer.vo.RegisterParamVO;
import idv.maxy.maxec.core.util.StringUtil;

/**
 * 
 * @author Max Chen
 *
 */
@Component
public class CustomerMutationResolver extends MutationResolver {
	private static final Logger logger = LoggerFactory.getLogger(CustomerMutationResolver.class);
	
	@Autowired
	private CustomerApiClient customerApiClient;

	// response types ----------------------------------------------------------------
	public static class RegisterResponse extends ResponseWrapperVO { }
	public static class DeregisterResponse extends ResponseWrapperVO { }

	
	// methods -------------------------------------------------------------------
	/**
	 * 
	 * @param param
	 * @return
	 */
	public RegisterResponse register(CustomerRegisterInputVO input) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		try {
			String inName = input.getName();
			String inUsername = input.getUsername();
			String inPassword = input.getPassword();
			String inEmail = input.getEmail();
			String inConfirmPassword = input.getConfirmPassword();
			
			if(StringUtil.isEmptyOrNull(inName)) { throw new Exception("name is empty"); }
			if(StringUtil.isEmptyOrNull(inUsername)) { throw new Exception("username is empty"); }
			if(StringUtil.isEmptyOrNull(inPassword)) { throw new Exception("password is empty"); }
			if(StringUtil.isEmptyOrNull(inEmail)) { throw new Exception("email is empty"); }
			if(StringUtil.isEmptyOrNull(inConfirmPassword)) { throw new Exception("confirm password is empty"); }
			if(!inConfirmPassword.equals(inPassword)) { throw new Exception("password not match"); }
			
			RegisterParamVO param = new RegisterParamVO();
			param.setEmail(inEmail);
			param.setName(inName);
			param.setPassword(inPassword);
			param.setUsername(inUsername);
			customerApiClient.register(param);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("register failed", ex);
		}
		
		RegisterResponse resp = new RegisterResponse();
		resp.setResult(code, errMsg);
		return resp;
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public DeregisterResponse deregister(String username, String id) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		try {
			if(StringUtil.isEmptyOrNull(id)) { throw new Exception("id is empty"); }
			if(StringUtil.isEmptyOrNull(username)) { throw new Exception("username is empty"); }
			customerApiClient.deregister(username, id);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("deregister failed", ex);
		}
		
		DeregisterResponse resp = new DeregisterResponse();
		resp.setResult(code, errMsg);
		return resp;
	}
}
