package com.om.common.vo;

import java.io.Serializable;
import java.util.List;

import com.om.web.entity.Good;

public class PageObject<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4288938782658423221L;
	/**
	 * 总行数,总页数，当前页码，页面大小，当前页记录信息
	 */
	//总行数
	private Integer rowCount=0; 
	//总页数
	private Integer pageCount=0;
	//当前页码
	private Integer pageCurrent=1;
	//页面大小
	private Integer pageSize=3;
	//当前页记录信息
	private List<T> records;
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0)pageCount++;
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public void setRecodes(List<Good> goods) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
