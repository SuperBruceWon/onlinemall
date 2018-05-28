package com.om.web.dao;

import java.util.List;

import com.om.web.entity.ExportUsers;

public interface SysUserDao {
	List<ExportUsers> findObjectsbyDeptID(/*@Param("deptId")Integer deptId*/);
}
