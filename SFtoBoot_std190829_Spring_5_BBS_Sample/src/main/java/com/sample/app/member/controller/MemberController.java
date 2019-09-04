package com.sample.app.member.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.app.common.LatestURI;
import com.sample.app.member.model.MemberDTO;
import com.sample.app.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService bitMemberService;

	/**
	 * 로그인 페이지를 보여주는 기능
	 * 
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login.tiles";
	}

	/**세션에서 로그인 정보를 없애고, 로그아웃을 클릭하기 직 전 페이지로 돌아가는 메소드.
	 * @param req
	 * @param uri
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest req,LatestURI uri) {
				
		logger.info("uri : " + uri.toString());
		
		
		req.getSession().removeAttribute("login");
		//return "login.tiles";
		//return req.getSession().getAttribute("latestURI") + "";
		return "redirect:" + uri.getUri();
	}

	/**
	 * 회원가입 페이지를 보여주는 기능
	 * 
	 * @return
	 */
	@RequestMapping(value = "regi", method = RequestMethod.GET)
	public String regi() {
		return "regi.tiles";
	}

	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String account() {
		logger.info("BitMemberController account " + new Date());
		return "regi";
	}

	@RequestMapping(value = "accountAf", method = RequestMethod.POST)
	public String accountAf(MemberDTO dto, Model model, HttpServletRequest req) throws Exception {
		logger.info("BitMemberController accountAf " + new Date());
		logger.info(dto.toString());

		boolean b = bitMemberService.addmember(dto);
		if (b) {
			logger.info("회원가입되었습니다 " + new Date());
			return "ok";
		}

		return "regi";
	}

	/**
	 * Ajax 통신을 통해 아이디 중복여부를 검사하는 기능
	 * 
	 * @param mem
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getId", method = RequestMethod.POST)
	public String getId(MemberDTO mem) {

		int count = bitMemberService.getId(mem);

		String msg = "";
		if (count > 0) {
			msg = "NO";
		} else {
			msg = "OK";
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "regiAf", method = RequestMethod.POST)
	public String regiAf(MemberDTO dto) throws Exception {

		boolean b = bitMemberService.addmember(dto);
		if (b) {
			return "redirect:/login";
		} else {
			return "redirect:/regi";
		}
	}

	@RequestMapping(value = "loginAf", method = RequestMethod.POST)
	public String loginAf(MemberDTO dto, HttpServletRequest req) {
		logger.info("KhMemberController loginAf " + new Date());

		MemberDTO login = bitMemberService.login(dto);

		if (login != null && !login.getId().equals("")) {
			logger.info("KhMemberController loginAf SUC " + new Date());
			// session 저장
			req.getSession().setAttribute("login", login);

			return "redirect:/bbslist";
		} else {
			logger.info("KhMemberController loginAf Fail " + new Date());
			return "login";
		}
	}
}
