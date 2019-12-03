package com.qa.pojo;

public class User {

	public String FirstName;
	public String LastName;
	public String UserName;
	public String Password;
	public String Email;

	public User(String FirstName, String LastName, String UserName, String Password, String Email) {

		this.FirstName = FirstName;
		this.LastName = LastName;
		this.UserName = UserName;
		this.Password = Password;
		this.Email = Email;

	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
