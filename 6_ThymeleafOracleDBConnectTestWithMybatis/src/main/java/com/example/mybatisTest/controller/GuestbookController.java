package com.example.mybatisTest.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mybatisTest.model.dto.GuestbookDTO;
import com.example.mybatisTest.service.GuestbookService;

@Controller
public class GuestbookController {
	
	@Inject
	GuestbookService guestbookService;
	
	@RequestMapping("list.do")
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("list");//이동할 view의 이름 설정
		List<GuestbookDTO> list = guestbookService.list();
		mav.addObject("list", list);//데이터 저장
		return mav;//화면 출력		
	}
	
	@RequestMapping("showhtml")
	public ModelAndView test1(ModelAndView mav) {
		mav.setViewName("welcome");
		mav.addObject("message", "스프링 부트 애플리케이션");
		return mav;
	}
}
