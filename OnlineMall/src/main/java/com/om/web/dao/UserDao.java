package com.om.web.dao;

import com.om.web.entity.User;

public interface UserDao {
	/**
	 * 根据用户名查找用户信息
	 * @param username
	 * @return1
	 */
	public User findByName(String name);
	/**
	 * 保存用户信息
	 * 
	 */
	public int saveObject(User entity);

}
