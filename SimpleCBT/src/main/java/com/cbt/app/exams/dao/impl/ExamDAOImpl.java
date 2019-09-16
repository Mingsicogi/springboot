package com.cbt.app.exams.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cbt.app.exams.dao.ExamDAO;
import com.cbt.app.exams.model.ExamConditionDTO;
import com.cbt.app.exams.model.ExamDTO;

@Repository
public class ExamDAOImpl implements ExamDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "Exam.";
	
	/**모든 시험정보를 가져오는 메소드
	 *
	 */
	@Override
	public List<ExamConditionDTO> getAllExams() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getAllExams");
	}

	/**하나의 시험정보를 가져오는 메소드
	 *
	 */
	@Override
	public ExamConditionDTO getOneExam( ExamConditionDTO dto  ) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getOneExam" , dto);
	}

	/**하나의 시험정보를 저장하는 메소드
	 *
	 */
	@Override
	public int insertNewExam(ExamConditionDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(ns + "insertNewExam", dto );
	}
	
	/**seq에 맞는 exam 1개를 DB에서 가져오는 메소드
	 * @param seq
	 * @return
	 */
	@Override
	public ExamDTO getOneExamBySeq(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getOneExamBySeq", seq);
	}

	/**subject 번호에 맞는 exam들을 모두 가져오는 메소드
	 *
	 */
	@Override
	public List<ExamDTO> getExamsBySubjectSeq(int subjectSeq) {
		// TODO Auto-generated method stub		
		return sqlSession.selectList(ns + "getExamsBySubjectSeq", subjectSeq);
		
	}
	
}
