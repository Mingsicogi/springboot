package com.exam.app.common.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.app.common.model.TestDTO;



@Controller
public class TestController {

	
	@Autowired
	SqlSession sqlSession;
	
	String ns = "common.";
	
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		System.out.println("컨트롤러!!!!!!!!!!");
		
		List<TestDTO> lst = sqlSession.selectList(ns + "getList");
		
		System.out.println("리스트 길이 : " + lst.size());
		
		model.addAttribute("list", lst);
		
		return "welcome";
	}
	
	@RequestMapping("/welcome2")
	public String welcome2() {
		System.out.println("2222222222222컨트롤러!!!!!!!!!!");
		return "tests/jsregularexpressiontest";
	}
}
