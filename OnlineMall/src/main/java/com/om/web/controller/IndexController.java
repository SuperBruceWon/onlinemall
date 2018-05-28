package com.om.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("indexUI")
	public String indexUI(){
		return "index";
	}
	@RequestMapping("doLogout")
	public String doLogout(){
		return "login_user";
	}
	

	@RequestMapping("khUI")
	public String khUI(){
		return "kh-khgl";
	}

	@RequestMapping("kffpUI")
	public String kffp(){
		return "ck-kffp";
	}
	@RequestMapping("ckglUI")
	public String ckgl(){
		return "ckgl";
	}
	@RequestMapping("ddglUI")
	public String ddgl(){
		return "dd-ddgl";
	}
	@RequestMapping("ckdUI")
	public String ckd(){
		return "cj-ckd";
	}
	
	
	
	
	
	
	
	
	
	
}
