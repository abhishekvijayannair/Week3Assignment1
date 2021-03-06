/**
 * 
 */
package com.groupb.week3.assignment1.model;

/**
 * @Date - 30/01/2022
 * @Author - Jith Koshy
 * @Description - This object model create the model for the admin user.
 */
public class UserModel {
	private String username;
	private String password;

	public UserModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
