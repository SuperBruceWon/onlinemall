package com.om.web.entity;

import java.io.Serializable;

public class Custorm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6069275967863057007L;
	private Integer admin_id;
	private String admin_name;
	private Integer  admin_password;
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public Integer getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(Integer admin_password) {
		this.admin_password = admin_password;
	}
	@Override
	public String toString() {
		return "Custorm [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_password=" + admin_password
				+ "]";
	}
	
	

}
