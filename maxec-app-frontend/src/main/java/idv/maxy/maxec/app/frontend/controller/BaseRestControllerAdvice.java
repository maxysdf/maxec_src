package idv.maxy.maxec.app.frontend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import idv.maxy.maxec.app.frontend.vo.ResponseVO;
import idv.maxy.maxec.core.util.StringUtil;

/**
 * 
 * @author Max Chen
 *
 */
@RestControllerAdvice(basePackageClasses=BaseRestController.class)
public class BaseRestControllerAdvice {
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseVO handleException(Exception ex) {
		String errMsg = ex.getMessage();
		if(StringUtil.isEmptyOrNull(errMsg)) { errMsg = "unknown error"; }
		
		ResponseVO r = new ResponseVO();
		r.setCode("99999");
		r.setErrorMessage(errMsg);
		return r;
	}
	
	
	
	
}
