package com.qa.pojo;

public class SuccessResponse {

	public String SuccessCode;
	public String Message;

	public SuccessResponse() {

	}

	public SuccessResponse(String SuccessCode, String Message) {

		this.SuccessCode = SuccessCode;
		this.Message = Message;
	}

	public String getSuccessCode() {
		return SuccessCode;
	}

	public void setSuccessCode(String successCode) {
		SuccessCode = successCode;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
