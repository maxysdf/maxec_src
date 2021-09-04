package idv.maxy.maxec.app.backend.graphql.vo;

public class ResponseVO {
	public static final String CODE_SUCCESS = "00000";
	public static final String CODE_UNKNOWN_ERROR = "99999";
	
	private boolean result;
	private String code;
	private String errorMessage;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
