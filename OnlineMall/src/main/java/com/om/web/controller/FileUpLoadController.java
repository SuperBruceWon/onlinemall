package com.om.web.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.om.common.util.FileUtil;
import com.om.web.service.SysUserService;

@Controller
@RequestMapping("/")
public class FileUpLoadController {
	@Autowired
	private SysUserService sysUserService;
	@RequestMapping("download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
            Model model) throws UnsupportedEncodingException{
		String url = sysUserService.findObjectsByDeptId();
		//String path = "src/main/webapp/WEB-INF/pages/userfile";
		File file = new File(url);
		HttpHeaders headers = new HttpHeaders();
		//String downloadFielName = new String("users.xls".getBytes("UTF-8"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", "users.xls");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtil.file2Byte(file),
	                headers, HttpStatus.CREATED);
	}
}
