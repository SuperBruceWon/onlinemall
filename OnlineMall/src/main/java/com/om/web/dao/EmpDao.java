package com.om.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.om.web.entity.Employee;

public interface EmpDao {
	/**
	 * 分页查询
	 * @param name
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Employee> findPageObjects(
			@Param("username")String username);
	
	int getRowCount(@Param("username")String username);
	
	//删除
	int deleteObject(@Param("ids")String[] ids);
	
//	//查询
	Employee findEmpById(Integer id);
	
	//添加
	int addEmp(Employee entity);
	
	//修改
	int updateEmp(Employee entity);

}
