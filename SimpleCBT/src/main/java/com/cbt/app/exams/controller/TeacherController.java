package com.cbt.app.exams.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cbt.app.exams.model.ExamConditionDTO;
import com.cbt.app.exams.model.ExamSubDTO;
import com.cbt.app.exams.model.ExamSubListDTO;
import com.cbt.app.exams.model.SubjectDTO;
import com.cbt.app.exams.service.ExamService;
import com.cbt.app.exams.service.ExamSubService;
import com.cbt.app.exams.service.SubjectService;
import com.cbt.app.member.model.MemberDTO;

@Controller
public class TeacherController {
	
	@Autowired
	private SubjectService subjectService;	
	@Autowired
	private ExamService examService;
	@Autowired
	private ExamSubService examSubService;
	
	
	@RequestMapping(value = "teacher/main")
	public String teacherMain() {
		return "teacher/main";
	}	
	
	/**새 시험 조건을 등록하는 뷰로 이동하는 메소드
	 * @return
	 */
	@RequestMapping(value = "teacher/newexam")
	public String teacherNewExam(Model model, HttpServletRequest req) {
		
		int teacherNum = 0;
		
		//세션에 저장된 아이디의 인증번호가 교수자가 아니면 다시 로그인하게끔 설정
		if( req.getSession().getAttribute("curruser") != null ) {
			if( 2 != ( (MemberDTO)req.getSession().getAttribute("curruser") ).getAuth() ) {
				return "redirect:/teacher/main";
			}else {
				//인증번호가 교수자이면 교수자의 고유번호 getSeq
				teacherNum = ( (MemberDTO)req.getSession().getAttribute("curruser") ).getSeq();
			}
		}else {
			//세션에 저장된 아이디가 없으면 메인페이지로 이동
			return "redirect:/teacher/main";
		}
		
		//계정정보 검사내용을 통과했으면 해당 교수자가 갖는 시험정보를 다음 뷰로 전송
		List<SubjectDTO> lst = subjectService.getSubjectsByTeacherNum(teacherNum);
		model.addAttribute("subjectlist",lst);
		
		return "teacher/newexam";
	}
		
	/**새 시험 생성조건에 따라 새 시험의 문제를 등록하는 뷰로 이동하는 메소드
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "teacher/newexam/detail", method = {RequestMethod.POST, RequestMethod.GET})
	public String teacherNewExamDetail(Model model, ExamConditionDTO dto) {
		//ExamConditionDTO의 내용대로 새로운 Exam을 DB에 저장
		//해당 시험(Exam)의 문제를 만들기 위해 저장한 Exam의 seq를 전달
		examService.insertNewExam(dto);
		
		dto.setSeq(examService.getOneExam(dto).getSeq());
		
		System.out.println("시험내용:" + dto);
		model.addAttribute("cond", dto);
		
		return "teacher/newexam/detail";
	}
	
	/**작성한 모든 문제를 DB에 저장하는 메소드
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "teacher/newexam/detail/save", method = {RequestMethod.POST, RequestMethod.GET})
	public String teacherNewExamDetailSave(Model model, @ModelAttribute(value="ExamSubListDTO") ExamSubListDTO l) {
		
		for( ExamSubDTO d : l.getExamSubList() ) {
			System.out.println(d);
			examSubService.insertNewExamsub(d);
		}
		
		return "redirect:/teacher/main";
	}
}
