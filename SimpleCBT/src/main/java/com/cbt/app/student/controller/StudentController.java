package com.cbt.app.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cbt.app.exams.model.ExamDTO;
import com.cbt.app.exams.model.SubjectDTO;
import com.cbt.app.exams.service.ExamDetailService;
import com.cbt.app.exams.service.ExamService;
import com.cbt.app.exams.service.SubjectService;
import com.cbt.app.member.model.MemberDTO;
import com.cbt.app.student.model.AttenderDTO;
import com.cbt.app.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;	
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ExamService examService;
	@Autowired
	private ExamDetailService examDetailService;
	
	/**학습자 메인뷰로 이동
	 * @param mem
	 * @return
	 */
	@RequestMapping(value = "/student/main", method = { RequestMethod.POST, RequestMethod.GET })
	public String showMain(Model model) {

		return "student/main";
	}

	/**학습자의 시험 목록 뷰로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/student/examlist", method = { RequestMethod.POST, RequestMethod.GET })
	public String showExamlist(Model model, HttpServletRequest req) {
		int studentSeq = ( (MemberDTO)req.getSession().getAttribute("curruser")).getSeq();
		//특정 학습자가 어떤 강의를 수강하고 있는지 여부를 model에 추가
		//1. AttenderDTO에서 student_seq가 갖는 subject_seq에 따라 subject_seq를 보여준다. -> subjectMap
		//2. subject_seq에 따라 CBT_EXAM에서 시험정보를 찾아서 뿌려준다.	->	examMap
		List<AttenderDTO> attList = studentService.getAllAttendenceInfoOfOneStudent(studentSeq);
		List<SubjectDTO> subjectList = new ArrayList<SubjectDTO>();
		List<ExamDTO> examList = new ArrayList<ExamDTO>();
				
		int w = 0;//examMap을 제어하기 위한 변수
		for( AttenderDTO d : attList ) {
			int sbjSeq = d.getSubject_seq();
			subjectList.add( subjectService.getSubjectBySeq( sbjSeq ) );	//subject_seq에 맞는 모든 과목정보를 subjectList에 저장
			for( ExamDTO examDto : examService.getExamsBySubjectSeq(sbjSeq) ) {	//subject_seq에 맞는 모든 시험정보를 examList에 저장
				examList.add(examDto);
			}			
		}
		
		System.out.println("수강중인 과목 출력합니다.");
		System.out.println("attList정보 : " + attList.toString());
		System.out.println("subjectList정보 : " + subjectList.toString());
		System.out.println("examList정보 : " + examList.toString());
		
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("examList", examList);
		
		//3. CBT_EXAM 중 CBT_EXAM_DETAIL 정보에 따라 응시여부를 알려준다. K,V == exam_seq, exam_seq에 해당하는 detail의 문제 수(응시문제수)
		Map<Integer, Integer> examResult = new HashMap<Integer, Integer>();
		if( examDetailService.getExamDetailCount(8) == null ) {
			System.out.println("null입니다...");
		}else {
			System.out.println("null 아닙니다...");
		}
//		for( ExamDTO e : examList ) {
//			examResult.put( e.getSeq() , examDetailService.getExamDetailCount(e.getSeq()) );
//			
//		}
//		model.addAttribute("examResult" , examResult);
		
		
		
		return "student/examlist";
	}

	/**학습자의 성적관리 뷰로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/student/grades", method = { RequestMethod.POST, RequestMethod.GET })
	public String showGrades(Model model) {

		return "student/main";
	}

}
