package com.fbExam.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CommonController {
	
	@RequestMapping("/")
	public String rootIndex() {
		return "index";
	}
}
