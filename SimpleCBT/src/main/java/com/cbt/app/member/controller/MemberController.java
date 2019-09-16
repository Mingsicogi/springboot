package com.cbt.app.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.app.common.util.LatestURI;
import com.cbt.app.member.model.MemberDTO;
import com.cbt.app.member.service.MemberService;

/**세션유저정보 : curruser
 * @author minhj
 *
 */
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/**로그인 화면으로 이동
	 * @return
	 */
	@RequestMapping(value = "/login/main")
	public String showLogin() {
				
		return "login";
	}
	
	/**로그아웃을 수행하고 이전 페이지로 돌아가기
	 * @param req
	 * @param uri
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest req,LatestURI uri) {
	    req.getSession().removeAttribute("curruser");

	    return "redirect:" + uri.getUri();
	}

	
	/**회원가입 페이지로 이동
	 * @return
	 */
	@RequestMapping(value = "/regi", method = {RequestMethod.POST, RequestMethod.GET})
	public String showRegi(Model model, @RequestParam(defaultValue = "0")int memberType) {
		
		model.addAttribute("memberType", memberType);
		
		return "regi";
	}
	
	/** 회원가입 페이지에서 작성한 내용을 토대로 회원가입 수행
	 * @param mem
	 * @return
	 */
	@RequestMapping(value = "/regi/insert", method = {RequestMethod.POST, RequestMethod.GET} )
	public String insertNewMember(Model model, MemberDTO dto, HttpServletRequest req ) {
		
		int auth = dto.getAuth();
		
		if( auth == 2 ) {
			//교수자인 경우
			int n = memberService.addTeacher(dto);
			if(n > 0 ) {
				req.getSession().setAttribute("curruser", dto);
				return "redirect:/teacher/main";
			}else {
				return "redirect:/regi?memberType=2";
			}					
		}else if (auth == 3) {
			//학생인 경우
			int n = memberService.addStudent(dto);
			if(n > 0 ) {
				req.getSession().setAttribute("curruser", dto);
				return "redirect:/student/main";
			}else {
				return "redirect:/regi?memberType=3";
			}
		}
		
		return "";
	}
	
	/**Ajax 통신을 통해 로그인 가능 여부를 검사하고 가능한 경우 로그인 수행
	 * @param mem
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login/do")
	public String doLogin(Model model, @RequestBody Map<String, Object> jsMap, HttpServletRequest req) {
		String inputId = jsMap.get("id") + "";
		String inputPw = jsMap.get("pw") + "";
		
		MemberDTO dto = new MemberDTO(inputId, inputPw);
				
		dto = memberService.login(dto);
		if ( dto == null ) {//로그인 실패한 경우		
			return "0";
		}else {//로그인 성공한 경우
			req.getSession().setAttribute("curruser", dto);			
			return dto.getAuth() + "";
		}		
	}
	
	/**Ajax 통신을 통해 아이디 중복여부를 검사
	 * @param mem
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/regi/findid", method = {RequestMethod.POST, RequestMethod.GET} )
	public String isDuplicatedId(Model model, @RequestBody Map<String, Object> jsMap) {
		String inputId = jsMap.get("id") + "";
		//특정 조건에 맞지 않으면 1 리턴(false)
		if( inputId.length() > 15 || ( inputId.equals(inputId.trim()) ) == false ) {
			return "1";
		}		
		//아이디가 있으면 1리턴, 없으면 0 리턴
		int isRegistered = memberService.getId(new MemberDTO(inputId, ""));		
		return isRegistered + "";
	}
	
	
}
