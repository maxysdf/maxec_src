package idv.maxy.maxec.app.frontend.controller;

import idv.maxy.maxec.app.frontend.vo.ResponseVO;

public class BaseRestController {
	
	public ResponseVO handleResponse(ResponseVO r) {
		r.setCode("00000");
		r.setErrorMessage(null);
		return r;
	}
}
