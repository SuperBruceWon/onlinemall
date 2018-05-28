package com.om.web.service;

import com.om.web.entity.User;

public interface UserService {
	
	User checkLogin(String name,String password);
	
	int saveObject(String username,String password,String password1,String email,String phone);

}
