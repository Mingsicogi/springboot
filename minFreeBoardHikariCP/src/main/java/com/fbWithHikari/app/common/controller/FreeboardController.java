package com.fbWithHikari.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreeboardController {
	
	@RequestMapping("/freeboard")
	public String freeboardRoot(Model model) {
		
		model.addAttribute("sss","sssvalue");
		
		return "freeboard/index";
	}
	
	@RequestMapping("/freeboard/fbsub/writenewpost")
	public String freeboardWriteNewPost() {
		
		return "freeboard/fbsub/writenewpost";
	}
}
