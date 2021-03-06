package model;

import java.io.Serializable;

public class Comment implements Serializable {

	private String user_id;
	private String user_name;
	private String works_id;
	private String comment;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Comment(){}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getWorks_id() {
		return works_id;
	}

	public void setWorks_id(String works_id) {
		this.works_id = works_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
