package com.om.web.entity;

import java.io.Serializable;
import java.sql.Date;

public class Judge implements Serializable{

	private static final long serialVersionUID = -5686721852718798810L;
	private Integer judge_id;
	private Integer user_id;
	private Integer good_id;
	private String judge_desc;
	private String judge_imgsrc01;
	private String judge_imgsrc02;
	private String judge_imgsrc03;
	private String judge_imgsrc04;
	private String judge_imgsrc05;
	private Date judge_createtime;
	public Integer getJudge_id() {
		return judge_id;
	}
	public void setJudge_id(Integer judge_id) {
		this.judge_id = judge_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	public String getJudge_desc() {
		return judge_desc;
	}
	public void setJudge_desc(String judge_desc) {
		this.judge_desc = judge_desc;
	}
	public String getJudge_imgsrc01() {
		return judge_imgsrc01;
	}
	public void setJudge_imgsrc01(String judge_imgsrc01) {
		this.judge_imgsrc01 = judge_imgsrc01;
	}
	public String getJudge_imgsrc02() {
		return judge_imgsrc02;
	}
	public void setJudge_imgsrc02(String judge_imgsrc02) {
		this.judge_imgsrc02 = judge_imgsrc02;
	}
	public String getJudge_imgsrc03() {
		return judge_imgsrc03;
	}
	public void setJudge_imgsrc03(String judge_imgsrc03) {
		this.judge_imgsrc03 = judge_imgsrc03;
	}
	public String getJudge_imgsrc04() {
		return judge_imgsrc04;
	}
	public void setJudge_imgsrc04(String judge_imgsrc04) {
		this.judge_imgsrc04 = judge_imgsrc04;
	}
	public String getJudge_imgsrc05() {
		return judge_imgsrc05;
	}
	public void setJudge_imgsrc05(String judge_imgsrc05) {
		this.judge_imgsrc05 = judge_imgsrc05;
	}
	public Date getJudge_createtime() {
		return judge_createtime;
	}
	public void setJudge_createtime(Date judge_createtime) {
		this.judge_createtime = judge_createtime;
	}
	@Override
	public String toString() {
		return "Judge [judge_id=" + judge_id + ", user_id=" + user_id + ", good_id=" + good_id + ", judge_desc="
				+ judge_desc + ", judge_imgsrc01=" + judge_imgsrc01 + ", judge_imgsrc02=" + judge_imgsrc02
				+ ", judge_imgsrc03=" + judge_imgsrc03 + ", judge_imgsrc04=" + judge_imgsrc04 + ", judge_imgsrc05="
				+ judge_imgsrc05 + ", judge_createtime=" + judge_createtime + "]";
	}
}
