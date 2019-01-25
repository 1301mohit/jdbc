/**
 * Purpose: POJO class of User
 * 
 * @author  Mohit Kumar
 * @version 1.0
 * @since   25/01/2019
 */
package com.bridgelabz.preparedstatement;

public class User {
	
	String userName;
	String userPassword;
	
	public User() {
		super();
	}

	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
}
