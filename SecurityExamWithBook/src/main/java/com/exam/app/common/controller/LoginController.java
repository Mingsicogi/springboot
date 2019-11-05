package com.exam.app.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	private PasswordEncoder pwe;
	
	@RequestMapping("/customlogin")
	public String loginMain() {		
		String pass = "ADMIN";		
		log.info("암호화전 : " + pass + ", 암호화후 : " + pwe.encode("pw"));		
		return "clogin";
	}
	
	@RequestMapping(value = "/customLogout", method = RequestMethod.GET)
	public String logoutGet() {
		log.info("Get logout");
		return "clogout";
	}
	
	@RequestMapping(value = "/customLogout", method = RequestMethod.POST)
	public void logoutPost() {
		log.info("Post logout");
	}
}
