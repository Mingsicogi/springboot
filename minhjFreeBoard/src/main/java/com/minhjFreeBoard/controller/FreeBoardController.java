package com.minhjFreeBoard.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhjFreeBoard.model.dto.PostsDTO;
import com.minhjFreeBoard.service.FreeBoardService;

@Controller
public class FreeBoardController {

	@Inject
	FreeBoardService freeBoardService;
	
	@RequestMapping("freeboard")
	public ModelAndView freeBoardMain(ModelAndView mav) {
		mav.setViewName("freeboard");
		List<PostsDTO> lst = freeBoardService.list();
		System.out.println("DB list size : " + lst.size()); //DB에서 받아온 List size 확인
		mav.addObject("list", lst);
		mav.addObject("chk","send ok");//보낸 데이터를 template이 잘 받았는지 확인
		return mav;
	}
	
	@RequestMapping("freeboard.writenew")
	public ModelAndView freeBoardWriteNew(ModelAndView mav) {
		mav.setViewName("fbsub/writenew");
		return mav;
	}
	
	@RequestMapping("freeboard.writenew.savepost")
	public void freeBoardInsert(@ModelAttribute(value="PostsDTO") PostsDTO dto) {
		System.out.println("왔다!");
		System.out.println(dto.toString());

	}
}
