package com.tiles.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CommonController {
	
	@GetMapping(value = {"", "index"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("main/index");
		
		return mav;
	}
	
	@GetMapping(value = "login")
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("main/login");
		
		return mav;
	}
	
	
	@GetMapping(value = "layout")
	public ModelAndView showLayout() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("main-layout");
		
		return mav;
	}
}
