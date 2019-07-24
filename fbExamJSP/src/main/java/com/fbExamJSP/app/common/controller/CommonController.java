package com.fbExamJSP.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	
	//index page "/"
	@RequestMapping("/")
	public ModelAndView hello(ModelAndView mav) {
		mav.setViewName("welcome");
		mav.addObject("message", "스프링 부트 애플리케이션");
		return mav;
	}
}
