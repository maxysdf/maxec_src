package idv.maxy.maxec.biz.content.vo;

public class UploadResultVO {
	private boolean result;
	private String code;
	private String errorMessage;
	
	public boolean isResult() {
		return result;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getCode() {
		return code;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
