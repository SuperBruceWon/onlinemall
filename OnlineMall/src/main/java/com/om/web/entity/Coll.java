package com.om.web.entity;

import java.io.Serializable;
import java.util.Date;

public class Coll implements Serializable{

	private static final long serialVersionUID = -5052278625882779196L;
	private Integer coll_id;
	private Integer user_id;
	private Date coll_createtime;
	public Integer getColl_id() {
		return coll_id;
	}
	public void setColl_id(Integer coll_id) {
		this.coll_id = coll_id;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Date getColl_createtime() {
		return coll_createtime;
	}
	public void setColl_createtime(Date coll_createtime) {
		this.coll_createtime = coll_createtime;
	}
	@Override
	public String toString() {
		return "Coll [coll_id=" + coll_id + ", coll_createtime=" + coll_createtime + "]";
	}
	
	
}
