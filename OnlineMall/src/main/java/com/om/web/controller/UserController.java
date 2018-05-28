package com.om.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.om.common.vo.JsonResult;
import com.om.web.service.UserService;
@Controller
@RequestMapping("/")
public class UserController {
	@RequestMapping("loginUI")
	public String index(){
		return "login_user";
	}
	@RequestMapping("registerUI")
	public String register(){
		return "registered_user";
	}
	@RequestMapping("doGood")
	public String doGood(){
		return "pc";
	}
	
	@Resource
	private UserService userService;
	
	/**
	 * 注册控制
	 */
	@ResponseBody
	@RequestMapping("doRegister")
	public JsonResult doRegister(String username,String password,String password1,String email,String phone){
		System.out.println("password："+password+"password1："+password1);
		return new JsonResult(userService.saveObject(username,password,password1,email,phone));
	}
	
	/**
	 * 登录控制
	 */
	@ResponseBody
	@RequestMapping("doLogin")
	public JsonResult doLogin(String username,String password){
		System.out.println(username+password);
		return new JsonResult(userService.checkLogin(username,password));
	}
	
	
}
