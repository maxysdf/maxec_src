package idv.maxy.maxec.app.frontend.vo;

public class ResponseVO {
	private String code;
	private String errorMessage;
	
	public void success() {
		this.code = "00000";
		this.errorMessage = null;
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
