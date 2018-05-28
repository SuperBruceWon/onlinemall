package com.om.common.controller;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.om.common.exception.ServiceException;
import com.om.common.vo.JsonResult;
/**全局异常处理类*/
@ControllerAdvice
public class ControllerExceptionHandler {
	 @ExceptionHandler(IllegalArgumentException.class)
	 @ResponseBody
	 public JsonResult doHandleArgumentException(
			 IllegalArgumentException e){
		 return new JsonResult(e);
	 }
	 
	 @ExceptionHandler(ServiceException.class)
	 @ResponseBody
	 public JsonResult doHandleServiceException(ServiceException e){
		 return new JsonResult(e);
	 }
	 
	 @ExceptionHandler(Error.class)
	 @ResponseBody
	 public JsonResult doHandleError(Error e){
		 return new JsonResult(e);
	 }
	 
	 @ExceptionHandler(ShiroException.class)
	 @ResponseBody
	 public JsonResult doShiroException(
			 ShiroException e){
		 System.out.println("doShiroException");
		 //e.printStackTrace();
		 if(e instanceof AuthenticationException){
			 System.out.println("==AuthenticationException==");
			 return new JsonResult(0,"用户名或密码不正确");
		 }else if(e instanceof AuthorizationException){
			 return new JsonResult(0,"没有权限");
		 }else{
			 return new JsonResult(0,"权限系统维护中");
		 }
	 }
}
