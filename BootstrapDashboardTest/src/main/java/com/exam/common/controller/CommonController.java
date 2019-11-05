package com.exam.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {
	
	@RequestMapping("/welcome")
	public String welcome() {
		
		log.info("welcome!!!!!!!!!!!!!");
		return "/welcome";
	}
}
