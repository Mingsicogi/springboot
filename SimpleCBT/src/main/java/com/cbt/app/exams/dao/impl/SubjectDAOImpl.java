package com.cbt.app.exams.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cbt.app.exams.dao.SubjectDAO;
import com.cbt.app.exams.model.SubjectDTO;

@Repository
public class SubjectDAOImpl implements SubjectDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "Subject.";
	
	/**모든 과목정보 리턴
	 *
	 */
	@Override
	public List<SubjectDTO> getAllSubject(){
		return sqlSession.selectList(ns + "getAllSubject");
	}
	
	/**매개변수 교수자가 갖는 모든 과목정보 리턴
	 *
	 */
	@Override
	public List<SubjectDTO> getSubjectsByTeacherNum(int seq) {
		return sqlSession.selectList(ns + "getSubjectsByTeacherNum", seq);
	}

	/**매개변수 seq에 해당하는 특정 과목정보 리턴
	 *
	 */
	@Override
	public SubjectDTO getSubjectBySeq(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getSubjectBySeq", seq);
	}
}
 