package com.om.web.entity;

import java.io.Serializable;

public class Goods implements Serializable{

	private static final long serialVersionUID = 2831820645027626047L;
	private Integer goods_id;
	private Integer cart_id;
	private Integer order_id;
	private Integer good_id;
	private String good_name;
	private String good_desc;
	private String good_imgsrc;
	private Double good_price;
	private Integer good_amount = 1;
	

	public Integer getGoods_id() {
		return goods_id;
	}


	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}


	public Integer getCart_id() {
		return cart_id;
	}


	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}


	public Integer getOrder_id() {
		return order_id;
	}


	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}


	public Integer getGood_id() {
		return good_id;
	}


	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}


	public String getGood_name() {
		return good_name;
	}


	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}


	public String getGood_desc() {
		return good_desc;
	}


	public void setGood_desc(String good_desc) {
		this.good_desc = good_desc;
	}


	public String getGood_imgsrc() {
		return good_imgsrc;
	}


	public void setGood_imgsrc(String good_imgsrc) {
		this.good_imgsrc = good_imgsrc;
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


	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", cart_id=" + cart_id + ", order_id=" + order_id + ", good_id="
				+ good_id + ", good_name=" + good_name + ", good_desc=" + good_desc + ", good_imgsrc=" + good_imgsrc
				+ ", good_price=" + good_price + ", good_amount=" + good_amount + "]";
	}

}
