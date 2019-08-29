package com.welcome.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.welcome.common.service.CommonService;

@Controller
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value = "welcome")
	public String welcome(Model model) {
		logger.info("컨트롤러!!!!!!!!");
		model.addAttribute("service test", commonService.selectTest() );
		
		return "welcome";
	}
}
