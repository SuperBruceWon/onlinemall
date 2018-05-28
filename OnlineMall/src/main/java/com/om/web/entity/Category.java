package com.om.web.entity;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable{
	private static final long serialVersionUID = -149482692085750731L;
	private Integer category_id;
	private Integer parent_id;
	private String category_name;
	private Integer category_state;
	private Date category_createtime;
	private Date category_modifytime;
	
	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Integer getCategory_state() {
		return category_state;
	}

	public void setCategory_state(Integer category_state) {
		this.category_state = category_state;
	}

	public Date getCategory_createtime() {
		return category_createtime;
	}

	public void setCategory_createtime(Date category_createtime) {
		this.category_createtime = category_createtime;
	}

	public Date getCategory_modifytime() {
		return category_modifytime;
	}

	public void setCategory_modifytime(Date category_modifytime) {
		this.category_modifytime = category_modifytime;
	}

	@Override
	public String toString() {
		return "category [category_id=" + category_id + ", parent_id=" + parent_id + ", category_name=" + category_name
				+ ", category_state=" + category_state + ", category_createtime=" + category_createtime
				+ ", category_modifytime=" + category_modifytime + "]";
	}
	
}
