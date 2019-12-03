package com.qa.pojo;

public class UserUpdate {

	public String name;
	public String job;

	public UserUpdate(String name, String job) {

		this.name = name;
		this.job = job;
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

}
