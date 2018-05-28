package com.om.web.service;

import com.om.common.vo.PageObject;
import com.om.web.entity.Employee;

public interface EmpService {
	//分页
	PageObject<Employee> findPageObjects(String username,Integer pageCurrent);
	//删除
	int deleteObjects(String ids);
	//输入框查询
	Employee findEmpById(Integer id);
	//增加
	int addEmp(Employee entity);
	//修改
	int updateEmp(Employee entity);
}
