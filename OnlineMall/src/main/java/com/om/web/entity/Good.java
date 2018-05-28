package com.om.web.entity;

import java.io.Serializable;
import java.util.Date;

public class Good implements Serializable{

	private static final long serialVersionUID = -1141510896348704423L;
	private Integer good_id;
	private Integer good_status;
	private Integer category_id;
	private String good_name;
	private String good_imgsrc;
	private String good_desc;
	private Double good_price;
	private Integer good_amount;
	private Date good_createtime;
	private Date good_modifytime;
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	public Integer getGood_status() {
		return good_status;
	}
	public void setGood_status(Integer good_status) {
		this.good_status = good_status;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getGood_imgsrc() {
		return good_imgsrc;
	}
	public void setGood_imgsrc(String good_imgsrc) {
		this.good_imgsrc = good_imgsrc;
	}
	public String getGood_desc() {
		return good_desc;
	}
	public void setGood_desc(String good_desc) {
		this.good_desc = good_desc;
	}
	public Double getGood_price() {
		return good_price;
	}
	public void setGood_price(Double good_price) {
		this.good_price = good_price;
	}
	public Integer getGood_amount() {
		return good_amount;
	}
	public void setGood_amount(Integer good_amount) {
		this.good_amount = good_amount;
	}
	public Date getGood_createtime() {
		return good_createtime;
	}
	public void setGood_createtime(Date good_createtime) {
		this.good_createtime = good_createtime;
	}
	public Date getGood_modifytime() {
		return good_modifytime;
	}
	public void setGood_modifytime(Date good_modifytime) {
		this.good_modifytime = good_modifytime;
	}
	@Override
	public String toString() {
		return "Good [good_id=" + good_id + ", good_status=" + good_status + ", category_id=" + category_id
				+ ", good_name=" + good_name + ", good_imgsrc=" + good_imgsrc + ", good_desc=" + good_desc
				+ ", good_price=" + good_price + ", good_amount=" + good_amount + ", good_createtime=" + good_createtime
				+ ", good_modifytime=" + good_modifytime + "]";
	}
}
