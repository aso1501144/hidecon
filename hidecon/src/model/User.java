package model;

import java.io.Serializable;

public class User implements Serializable {

	private String user_id;
	private String password;

	public User(){}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		this.user_id = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
