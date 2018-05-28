package com.om.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.om.common.vo.JsonResult;
import com.om.common.vo.PageObject;
import com.om.web.entity.Custorm;
import com.om.web.service.CustormService;

@RequestMapping("/custorm/")
@Controller
public class CustormController {
	@Autowired
	private CustormService custormService;

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Custorm entity) {
		custormService.saveObject(entity);
		return new JsonResult("save ok");

	}



	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer admin_id,Integer pageCurrent) {
		PageObject<Custorm> pageObjects = custormService.findPageObjects(admin_id, pageCurrent);
		return new JsonResult(pageObjects);

	}
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer[] ids) {
		custormService.deleteObject(ids);
		return new JsonResult("delete ok");

	}
}
