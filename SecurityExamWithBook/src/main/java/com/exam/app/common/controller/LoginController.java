package com.exam.app.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Autowired
	private PasswordEncoder pwe;
	
	@RequestMapping("/customlogin")
	public String loginMain() {
		
		
		String pass = "qlalfqjsgh";
		
		System.out.println("암호화전 : " + pass);
		
		System.out.println("암호화후 : " + pwe.encode("pw"));
		
		
		return "clogin";
	}
}
