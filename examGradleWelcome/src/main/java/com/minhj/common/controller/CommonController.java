package com.minhj.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@RequestMapping(value = "/welcome")
	public String welcome() {
		
		System.out.println("welcome cnt");
		
		return "welcome";
	}
}
