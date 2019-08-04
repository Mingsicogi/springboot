package com.mybatisAndTransaction.app.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mybatisAndTransaction.app.common.service.AccessLogService;
import com.mybatisAndTransaction.app.common.service.MemberService;
import com.mybatisAndTransaction.app.common.vo.AccessLogVO;
import com.mybatisAndTransaction.app.common.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AccessLogService accessLogService;
	
	
	@RequestMapping(value="logTest",method= RequestMethod.GET)
	public String logTestPage(@RequestParam String logContent,Model model) {
		logger.info("[info] log test done. Message: " + logContent);
		
		AccessLogVO vo = new AccessLogVO();
		vo.setAccessPoint("log Test : " + logContent);
		vo.setId("5");
		
		accessLogService.saveAccessLog(vo);
		
		model.addAttribute("logContent", logContent);
		
		return "logTest";
	}

	
	@RequestMapping("/")
	public String root() {
		//MemberVO vo = new MemberVO(5, "cccc", "cccc@cccc");
		
		//memberService.addMember(vo);
		//accessLogService.saveAccessLog(vo);
		
		logger.info("[info]index access");
		
		return "index";
	}
	
	@RequestMapping("ddd")
	public String indexPage(ModelAndView mav) {
		mav.setViewName("index");
		System.out.println("controller ok!");
		return "/index.html";
	}
	
	@RequestMapping("/welcome")
	public String welcomePage() {
		
		return "welcome";
	}
}
