package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.om.web.dao.UserDao;
import com.om.web.entity.User;

public class TestUser {
	
	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	@Test
	public void testUserDao(){
		UserDao userDao = ctx.getBean("userDao",UserDao.class);
		User user = new User();
		user.setUser_name("woshidashabi");
		user.setUser_password("123456");
		user.setUser_phone("13366456802");
		user.setUser_email("dashj@qq.com");
		int saveObject = userDao.saveObject(user);
		System.out.println(saveObject);
	}
	
	
	
	@After
	public void close(){
		ctx.close();
		}

}
