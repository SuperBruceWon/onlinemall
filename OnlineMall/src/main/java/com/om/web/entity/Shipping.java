package com.om.web.entity;

import java.io.Serializable;
import java.util.Date;

public class Shipping implements Serializable{
	private static final long serialVersionUID = -8582226623252179195L;
	private Integer shipping_id;
	private String shipping_sn;
	private String shipping_name;
	private String shipping_address;
	private Integer shipping_status = 1;
	private Integer user_id;
	private String user_name;
	private String user_phone;
	private Date shipping_createtime;
	private Date shipping_completetime;
	
	public Integer getShipping_id() {
		return shipping_id;
	}

	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}

	public String getShipping_sn() {
		return shipping_sn;
	}

	public void setShipping_sn(String shipping_sn) {
		this.shipping_sn = shipping_sn;
	}

	public String getShipping_name() {
		return shipping_name;
	}

	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public Integer getShipping_status() {
		return shipping_status;
	}

	public void setShipping_status(Integer shipping_status) {
		this.shipping_status = shipping_status;
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

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public Date getShipping_createtime() {
		return shipping_createtime;
	}

	public void setShipping_createtime(Date shipping_createtime) {
		this.shipping_createtime = shipping_createtime;
	}

	public Date getShipping_completetime() {
		return shipping_completetime;
	}

	public void setShipping_completetime(Date shipping_completetime) {
		this.shipping_completetime = shipping_completetime;
	}

	@Override
	public String toString() {
		return "shipping [shipping_id=" + shipping_id + ", shipping_sn=" + shipping_sn + ", shipping_name="
				+ shipping_name + ", shipping_address=" + shipping_address + ", shipping_status=" + shipping_status
				+ ", user_name=" + user_name + ", user_phone=" + user_phone + ", shipping_createtime="
				+ shipping_createtime + ", shipping_completetime=" + shipping_completetime + "]";
	}
}
