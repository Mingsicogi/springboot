package com.cbt.app.exams.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cbt.app.exams.dao.ExamDetailDAO;
import com.cbt.app.exams.model.ExamResultDTO;

@Repository
public class ExamDetailDAOImpl implements ExamDetailDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "ExamDetail.";

	/**특정 시험의 응시문항 수 리턴
	 * 
	 */
	@Override
	public ExamResultDTO getExamDetailCount(int seq_exam) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getExamDetailCount");
	}

	/**특정 시험의 총점 리턴
	 *
	 */
	@Override
	public double getExamDetailSum(int seq_exam) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getExamDetailSum");
	}
	
	
}
