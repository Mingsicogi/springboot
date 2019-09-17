package com.exam.app.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/exam/*")
@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	
	@GetMapping("/all")
	public String welcome() {
		
		logger.info("welcome");
		
		return "welcome";
	}
	
	@GetMapping("/member")
	public String memberWelcome() {
		
		logger.info("member welcome");
		
		return "member/main";
	}
	
	@GetMapping("/admin")
	public String adminWelcome() {
		
		logger.info("admin welcome");
		
		return "admin/main";
	}
}
