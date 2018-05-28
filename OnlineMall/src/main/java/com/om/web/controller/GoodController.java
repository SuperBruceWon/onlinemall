package com.om.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.om.common.vo.JsonResult;
import com.om.web.entity.Good;
import com.om.web.service.GoodService;
@RequestMapping("/good/")
@Controller
public class GoodController {
	@Resource
	private GoodService goodService;
	
	
	
	@ResponseBody
	@RequestMapping("doSelectGood")
	public JsonResult doSelectGood(String name){
		Good good = goodService.findObjectsByName(name);
		return new JsonResult(good);
	}
}
