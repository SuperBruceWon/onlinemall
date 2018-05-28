package com.om.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.common.util.PoiUtils;
import com.om.web.dao.SysUserDao;
import com.om.web.entity.ExportUsers;
import com.om.web.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public String findObjectsByDeptId() {
		List<ExportUsers> users = sysUserDao.findObjectsbyDeptID(/*deptId*/);
		//System.out.println(users.get(0));
		PoiUtils poi = new PoiUtils();
		String url = poi.CreateExcelDemo(users);
		return url;
	}

	
	
}
