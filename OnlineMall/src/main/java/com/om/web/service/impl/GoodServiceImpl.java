package com.om.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.common.exception.ServiceException;
import com.om.web.dao.GoodDao;
import com.om.web.entity.Good;
import com.om.web.service.GoodService;
@Service
public class GoodServiceImpl implements GoodService {

	@Autowired
	private GoodDao goodDao;
	
	@Override
	public Good findObjectsByName(String name) {
		//1.验证name
		if(name==null)
		throw new ServiceException("商品名参数有误");
		//查询
		Good good = goodDao.findObjectsByName(name);
		if(good==null)
		throw new ServiceException("商品不存在");	
		return good;
	}

}
