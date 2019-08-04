package com.mhjFreeBoardv12.app.common.controller;
 
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mhjFreeBoardv12.app.freeboard.service.FreeboardService;
import com.mhjFreeBoardv12.app.freeboard.vo.FreeboardVO;

@Controller
public class CommonController {
	
	@Autowired
	private FreeboardService freeboardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeIndex(Locale locale, Model model) {
		
		//model.addAttribute("msg", "왔다!!!!!");
		
		FreeboardVO vo = new FreeboardVO(5, "2", "3", "1", new Date(), 3, 0);
		model.addAttribute("fbOne", freeboardService.getOnePost(vo));
		
		return "welcome";
	}
	
	@RequestMapping(value = "pdsupload", method = RequestMethod.POST)
	public String pdsSave(Locale locale, Model model) {
		
		
		
		return "pdsupload";
	}
	
	@RequestMapping("regex")
	public String jsTest1() {
		return "tests/jsregularexpressiontest";
	}
}
