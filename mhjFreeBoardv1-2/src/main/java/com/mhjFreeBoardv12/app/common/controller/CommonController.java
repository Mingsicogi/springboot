package com.mhjFreeBoardv12.app.common.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeIndex(Locale locale, Model model) {
		
		//model.addAttribute("msg", "왔다!!!!!");
		
		return "welcome";
	}
}
