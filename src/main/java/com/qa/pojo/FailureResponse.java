package com.qa.pojo;

public class FailureResponse {

	public FailureResponse() {

	}

	public String FaultId;
	public String fault;

	public FailureResponse(String FaultId, String fault) {

		this.FaultId = FaultId;
		this.fault = fault;
	}

	public String getFaultId() {
		return FaultId;
	}

	public void setFaultId(String faultId) {
		FaultId = faultId;
	}

	public String getFault() {
		return fault;
	}

	public void setFault(String fault) {
		this.fault = fault;
	}

}
