package com.fbExam.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CommonController {
	
	@RequestMapping("/welcome")
	public ModelAndView rootIndex(ModelAndView mav) {
		
		mav.setViewName("welcome");
		
		return mav;
	}
}
