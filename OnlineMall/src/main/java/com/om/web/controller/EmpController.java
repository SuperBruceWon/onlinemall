package com.om.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.om.common.vo.JsonResult;
import com.om.common.vo.PageObject;
import com.om.web.entity.Employee;
import com.om.web.service.EmpService;
@RequestMapping("/")
@Controller
public class EmpController {
	@Resource
	private EmpService empService;
	
	@RequestMapping("jbxxUI")
	public String listUI(){
		return "yg-jbxx";
	}
	@RequestMapping("afIndex")
	public String indexuI(){
		return "af_index";
	}
	@RequestMapping("addUpdUI")
	public String addUI(){
		return "addUpd";
	}
	@RequestMapping("addUI")
	public String insertUI(){
		return "insert";
	}
	
	
	
	
	@RequestMapping("doUpdateEmp")
	@ResponseBody
	public JsonResult doUpdateEmp(Employee entity){
		int rows = empService.updateEmp(entity);
		return new JsonResult(rows);
	}
	
	@RequestMapping("doAddEmp")
	@ResponseBody
	public JsonResult doAddEmp(Employee entity){
		int rows = empService.addEmp(entity);
		return new JsonResult(rows);
	}
	
	
	@RequestMapping("doFindEmp")
	@ResponseBody
	public JsonResult doFindEmp(Integer id){
		Employee emp = empService.findEmpById(id);
		return new JsonResult(emp);
	}
	
	
	@RequestMapping("doDeleteEmp")
	@ResponseBody
	public JsonResult doDeleteObjects(String ids){
		int rows= empService.deleteObjects(ids);
		return new JsonResult(rows);
	}
	

	@RequestMapping("doFindPageEmp")
	@ResponseBody
	public JsonResult doFindPage(String username,Integer pageCurrent){
		PageObject<Employee> list =
				empService.findPageObjects(username, pageCurrent);
		return new JsonResult(list);
	}
	
	
}
