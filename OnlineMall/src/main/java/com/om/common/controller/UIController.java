package com.om.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UIController {
	
	@RequestMapping("cartUI")
	public String cartUI(){
		return "myCart";
	}
	
	@RequestMapping("pageUI")
	public String pageUI(){
		return "page";
	}
	
	@RequestMapping("collUI")
	public String collUI(){
		return "myColl";
	}
}
