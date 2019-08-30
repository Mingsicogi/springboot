package com.sample.app.bbs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.app.bbs.model.BbsDTO;
import com.sample.app.bbs.model.BbsParam;
import com.sample.app.bbs.service.BbsService;

@Controller
public class BbsController {

	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService bbsService;
	
	@RequestMapping(value = "bbslist", method= {RequestMethod.POST, RequestMethod.GET})
	public String bbslist(Model model, BbsParam param) {		
		logger.info("BitBbsController : bbslist(), param:" + param.toString());
		
		model.addAttribute("doc_title", "글목록");//제목 설정		
		
		//paging 처리, 현재 페이지가 0이면 1~10까지, 1이면 11부터 20까지
		int sn = param.getPageNumber();
		int start = sn * param.getRecordCountPerPage() + 1;
		int end = (sn + 1) * param.getRecordCountPerPage();		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDTO> bbslist = bbsService.getBbsList(param);
		model.addAttribute("bbslist", bbslist);//게시판 글 세팅
		
		//검색조건에 맞는 글의 총 개수
		int totalRecordCount = bbsService.getBbsCount(param);
		
		//paging 정보 추가
		model.addAttribute("pageNumber" , sn);
		model.addAttribute("pageCountPerScreen" , 10);
		model.addAttribute("recordCountPerPage" , param.getRecordCountPerPage());
		model.addAttribute("totalRecordCount" , totalRecordCount);
		
		return "bbslist.tiles";
	}	
}