package com.logback.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {

	Logger logger = LoggerFactory.getLogger(CommonController.class);

	
	@RequestMapping(value = {"/", "/welcome"})
	public String welcome() {
		log.info("welcome()");
		log.error("welcome error log");
		logger.info("로그로그");
		logger.error("로그에러로그에러");
		return "welcome";
	}
}
