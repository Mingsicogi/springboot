package com.fbWithHikari.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FragmentsController {
	
	@RequestMapping("fragments/commonHeader")
	public String commonHeader() {
		return "fragments/commonHeader";
	}
}
