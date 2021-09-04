package idv.maxy.maxec.app.frontend.graphql.vo;

public class ResponseWrapperVO {
	private ResponseVO response;
	
	public void setResult(String code, String errorMessage) {
		response = new ResponseVO();
		response.setResult(ResponseVO.CODE_SUCCESS.equals(code));
		response.setCode(code);
		response.setErrorMessage(errorMessage);
	}
	
	public ResponseVO getResponse() {
		return response;
	}
	public void setResponse(ResponseVO response) {
		this.response = response;
	}
}
