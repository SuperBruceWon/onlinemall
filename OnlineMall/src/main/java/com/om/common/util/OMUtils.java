package com.om.common.util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;


public class OMUtils {
	
	public static String md5(String src) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] output = md.digest(src.getBytes());
		String s = Base64.encodeBase64String(output);
		return s;
	}

}
