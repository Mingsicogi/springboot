package com.sse.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping(value = "/welcome/main")
	public String welcome() {
		return "welcome";
	}
}
