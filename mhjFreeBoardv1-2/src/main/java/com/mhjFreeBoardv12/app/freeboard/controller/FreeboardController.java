package com.mhjFreeBoardv12.app.freeboard.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreeboardController {

	
	@RequestMapping(value = "freeboard/main", method = RequestMethod.GET)
	public String freeboardMain() {
		return "freeboard/freeboardmain";
	}
}
