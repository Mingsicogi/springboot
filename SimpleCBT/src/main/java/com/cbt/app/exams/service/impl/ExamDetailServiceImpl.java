package com.cbt.app.exams.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.app.exams.dao.ExamDetailDAO;
import com.cbt.app.exams.model.ExamResultDTO;
import com.cbt.app.exams.service.ExamDetailService;

@Service
public class ExamDetailServiceImpl implements ExamDetailService{
	@Autowired
	private ExamDetailDAO examDetailDAO;
	
	/**특정 시험의 응시문항 수 리턴
	 * 
	 */
	@Override
	public ExamResultDTO getExamDetailCount(int seq_exam) {
		// TODO Auto-generated method stub
		return examDetailDAO.getExamDetailCount(seq_exam);
	}

	/**특정 시험의 총점 리턴
	 *
	 */
	@Override
	public double getExamDetailSum(int seq_exam) {
		// TODO Auto-generated method stub
		return examDetailDAO.getExamDetailSum(seq_exam);
	}
}
