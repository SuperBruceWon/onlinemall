package com.om.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.om.web.entity.Custorm;



public interface CustormDao {
	List<Custorm> findPageObject(
			@Param("admin_id") Integer admin_id,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize
			);
	int getRowCount(@Param("admin_id") Integer admin_id);
	int deleteObject(@Param("ids") Integer[] ids);
	int insertObject(Custorm entity);
	
	
}
