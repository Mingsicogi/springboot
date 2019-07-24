package com.examFrag.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String rootIndex(Model model) {
		
		model.addAttribute("sss","sssvalue");
		
		return "index";
	}
}