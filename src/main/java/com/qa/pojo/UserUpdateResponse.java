package com.qa.pojo;

public class UserUpdateResponse {

	public String name;
	public String job;
	public String updatedAt;

	public UserUpdateResponse() {

	}

	public UserUpdateResponse(String name, String job, String updatedAt) {

		this.name = name;
		this.job = job;
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
