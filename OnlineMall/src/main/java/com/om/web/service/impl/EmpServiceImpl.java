package com.om.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.om.common.exception.ServiceException;
import com.om.common.vo.PageObject;
import com.om.web.dao.EmpDao;
import com.om.web.entity.Employee;
import com.om.web.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;


	@Override
	public PageObject<Employee> findPageObjects(String username, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new ServiceException("当前页码不正确");
		Integer pageSize=3;
		PageHelper.startPage(pageCurrent, pageSize);
		List<Employee> list = empDao.findPageObjects(username);
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		PageObject<Employee> pageObject = new PageObject<>();
		pageObject.setRecords(list);
		pageObject.setPageCount(pageInfo.getPages());
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(list);
		pageObject.setRowCount((int)pageInfo.getTotal());
		return pageObject;
	}

	@Override
	public int deleteObjects(String ids) {
		if(ids==""||ids==null)
			throw new ServiceException("用户参数不对");
		int rows = empDao.deleteObject(ids.split(","));
		if(rows==0)
			throw new ServiceException("删除数据不存在");
		return rows;
	}


//	@Override
//	public Employee findEmpByName(String username) {
//		if(username==null||username=="")
//			throw new ServiceException("用户名为空");
//		Employee emp = empDao.findEmpByName(username);
//		if(emp==null)
//			throw new ServiceException("没有找到这个用户");	
//		return emp;
//	}

	@Override
	public Employee findEmpById(Integer id) {
		if(id==null||id<=0)
		throw new ServiceException("用户id为空");
		Employee emp = empDao.findEmpById(id);
		if(emp==null)
		throw new ServiceException("没有找到这个用户");	
		return emp;
	}

	@Override
	public int addEmp(Employee entity) {
		if(entity==null)
			throw new ServiceException("添加对象为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ServiceException("用户名不能为空");
		int rows = empDao.addEmp(entity);
		return rows;
	}


	@Override
	public int updateEmp(Employee entity) {
		if(entity==null)
			throw new ServiceException("修改对象为空");
//		Employee emp = empDao.findEmpById(id);
//		if(emp.getId()==null||emp.getId()==0)
//			throw new ServiceException("用户id为空");
		int rows = empDao.updateEmp(entity);
		return rows; 
	}

	

//	@Override
//	public PageObject<Employee> findPageObjects(String username, Integer pageCurrent) {
//		int rowCount = empDao.getRowCount(username);
//		if(rowCount==0)
//		throw new ServiceException("总页数不能为零");	
//		if(pageCurrent==null||pageCurrent<=0)
//		throw new ServiceException("页码不符合规范");
//		int pageSize = 3;
//		int startIndex = (pageCurrent-1)*pageSize;
//		List<Employee> list = empDao.findPageObjects(username, startIndex, pageSize);
//		PageObject<Employee> page = new PageObject<>();
//		page.setRecords(list);
//		page.setRowCount(rowCount);
//		page.setPageSize(pageSize);
//		page.setPageCurrent(pageCurrent);
//		return page;
//	}

}
