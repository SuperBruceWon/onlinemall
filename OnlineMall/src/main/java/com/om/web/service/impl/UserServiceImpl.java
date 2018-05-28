package com.om.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.common.exception.ServiceException;
import com.om.web.dao.UserDao;
import com.om.web.entity.User;
import com.om.web.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Override
	public User checkLogin(String name, String password) {
		//用户名为空
		if(name==null||name=="")
		throw new ServiceException("请输入用户名");
		if(password==null||password=="")
		throw new ServiceException("请输入密码");
	
		User admin = userDao.findByName(name);
		if(admin==null)
		throw new ServiceException("用户名不存在");	
		//密码错误
//		try {
//			String md5Pwd = OMUtils.md5(password);
			if(!admin.getUser_password().equals(password))
			throw new ServiceException("密码错误");	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//登录成功
		return admin;
	}
	@Override
	public int saveObject(String username,String password,String password1,String email,String phone) {
		System.out.println("password："+password+"password1："+password1);
		
		//根据name查找用户
		User admin = userDao.findByName(username);
		//用户名存在
		if(admin!=null)
		throw new ServiceException("该用户已存在");
		//密码不一致
		if(!password.equals(password1))
		throw new ServiceException("确认密码有误");	
		//存储用户信息
		User user = new User();
		user.setUser_name(username);
		user.setUser_phone(phone);
		user.setUser_email(email);
		user.setUser_password(password);
		int rows = userDao.saveObject(user);
		System.out.println(rows);
		return rows;
	}
//	@Override
//	public int saveObject(UserRegister userRegister) {
//		System.out.println(userRegister);
//		User user =
//		userDao.findByName(userRegister.getUser_name());
//		if(user.getUser_name().equals(userRegister.getUser_name()))
//		throw new ServiceException("用户名已存在");
//		int rows = userDao.saveObject(user);
//		System.out.println(rows);
//		return rows;
//	}

}
