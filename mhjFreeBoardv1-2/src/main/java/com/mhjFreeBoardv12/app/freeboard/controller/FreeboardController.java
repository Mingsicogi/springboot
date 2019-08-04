package com.mhjFreeBoardv12.app.freeboard.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mhjFreeBoardv12.app.freeboard.service.FreeboardService;
import com.mhjFreeBoardv12.app.freeboard.vo.FreeboardVO;

@Controller
public class FreeboardController {

	@Autowired
	private FreeboardService freeboardService;
	
	
	@RequestMapping(value = "freeboard/main", method = RequestMethod.GET)
	public String freeboardMain(Model model) {
		
		List<FreeboardVO> lst = freeboardService.getAllPost();
		
		model.addAttribute("postList", lst);
		
		return "freeboard/freeboardmain";
	}
	
	@RequestMapping(value = "freeboard/postdetail")
	public String freeboardPostDetail(Model model) {
		return "freeboard/postdetail";
	}
}
