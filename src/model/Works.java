package model;

import java.io.Serializable;

public class Works implements Serializable {

	private String works_id;
	private String works_name;
	private String creator_name;
	private int works_count;
	private String path;

	public Works(){}

	public String getWorks_id() {
		return works_id;
	}

	public void setWorks_id(String works_id) {
		this.works_id = works_id;
	}

	public String getWorks_name() {
		return works_name;
	}

	public void setWorks_name(String works_name) {
		this.works_name = works_name;
	}

	public String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}

	public int getWorks_count() {
		return works_count;
	}

	public void setWorks_count(int works_count) {
		this.works_count = works_count;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
