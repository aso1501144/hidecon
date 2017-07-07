package model;

import java.io.Serializable;

public class User implements Serializable {

	private String user_id;
	private String password;
	private String user_name;
	private int flag;

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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}


}
