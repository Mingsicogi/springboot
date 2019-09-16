package com.cbt.app.exams.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.app.exams.dao.ExamDAO;
import com.cbt.app.exams.model.ExamConditionDTO;
import com.cbt.app.exams.model.ExamDTO;
import com.cbt.app.exams.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private ExamDAO examDAO;
	
	/**모든 시험정보를 가져오는 메소드
	 *
	 */
	@Override
	public List<ExamConditionDTO> getAllExams() {
		// TODO Auto-generated method stub
		return examDAO.getAllExams();
	}

	/**하나의 시험정보를 가져오는 메소드
	 *
	 */
	@Override
	public ExamConditionDTO getOneExam( ExamConditionDTO dto  ) {
		// TODO Auto-generated method stub
		return examDAO.getOneExam(dto);
	}

	/**하나의 시험정보를 저장하는 메소드
	 *
	 */
	@Override
	public int insertNewExam(ExamConditionDTO dto) {
		// TODO Auto-generated method stub
		return examDAO.insertNewExam(dto);
	}

	/**seq에 맞는 exam 1개를 DB에서 가져오는 메소드
	 * @param seq
	 * @return
	 */
	@Override
	public ExamDTO getOneExamBySeq(int seq) {
		// TODO Auto-generated method stub
		return examDAO.getOneExamBySeq(seq);
	}

	/**subject 번호에 맞는 exam들을 모두 가져오는 메소드
	 *
	 */
	@Override
	public List<ExamDTO> getExamsBySubjectSeq(int subjectSeq) {
		// TODO Auto-generated method stub
		return examDAO.getExamsBySubjectSeq(subjectSeq);
	}
	
}
