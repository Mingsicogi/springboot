package com.cbt.app.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
	
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "/test")
	public String testView() {
		return "test";
	}
	
	@RequestMapping(value = "/listtest" , method = {RequestMethod.POST, RequestMethod.GET})
	public String listtest(Model model, @ModelAttribute(value="ExamTestListDTO") ExamTestListDTO l) {
		System.out.println("리스트 테스트!!! 받았다!!!");
		System.out.println(l);
		return "test";
	}
	
	@RequestMapping(value = "/logingo")
	public String login() {
		System.out.println("로그인 거쳤음");
		return "member/login";
	}
}
