package com.om.web.entity;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable{

	private static final long serialVersionUID = 1172986675463035900L;
		
	private Integer cart_id;
	private Integer user_id;
	private Date cart_createtime;
	public Integer getCart_id() {
		return cart_id;
	}
	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Date getCart_createtime() {
		return cart_createtime;
	}
	public void setCart_createtime(Date cart_createtime) {
		this.cart_createtime = cart_createtime;
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", cart_createtime=" + cart_createtime + "]";
	}	
}
