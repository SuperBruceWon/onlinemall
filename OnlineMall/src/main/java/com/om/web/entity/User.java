package com.om.web.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = -5828408064173896674L;
	private Integer user_id;
	private String user_name;
	private String user_password;
	private String user_realname;
	private String user_gender;
	private String user_imgstr;
	private String user_phone;
	private String user_email;
	private Integer user_level;
	private Integer user_status;
	private Date user_birth;
	private Date user_createtime;
	private Date user_modifitime;
	
	
	
	
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_imgstr() {
		return user_imgstr;
	}
	public void setUser_imgstr(String user_imgstr) {
		this.user_imgstr = user_imgstr;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Integer getUser_level() {
		return user_level;
	}
	public void setUser_level(Integer user_level) {
		this.user_level = user_level;
	}
	public Integer getUser_status() {
		return user_status;
	}
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}
	public Date getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}
	public Date getUser_createtime() {
		return user_createtime;
	}
	public void setUser_createtime(Date user_createtime) {
		this.user_createtime = user_createtime;
	}
	public Date getUser_modifitime() {
		return user_modifitime;
	}
	public void setUser_modifitime(Date user_modifitime) {
		this.user_modifitime = user_modifitime;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_realname=" + user_realname + ", user_gender=" + user_gender + ", user_imgstr=" + user_imgstr
				+ ", user_phone=" + user_phone + ", user_email=" + user_email + ", user_level=" + user_level
				+ ", user_status=" + user_status + ", user_birth=" + user_birth + ", user_createtime=" + user_createtime
				+ ", user_modifitime=" + user_modifitime + "]";
	}
	

}
