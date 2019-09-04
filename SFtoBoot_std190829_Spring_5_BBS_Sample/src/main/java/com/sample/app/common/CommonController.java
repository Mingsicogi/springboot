package com.sample.app.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping(value = "welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "memo")
	public String memo() {
		return "memo";
	}
}
