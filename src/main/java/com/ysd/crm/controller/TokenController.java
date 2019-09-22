package com.ysd.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.crm.util.TokenUtil;

@Controller
public class TokenController {
	
	
	@RequestMapping(value = "/verifyToken", method = RequestMethod.POST)
	@ResponseBody
	public boolean verifyToken(String token) {
		
		return TokenUtil.parserTonken(token).get("secretKey").equals("哈哈");
		
	}
}
