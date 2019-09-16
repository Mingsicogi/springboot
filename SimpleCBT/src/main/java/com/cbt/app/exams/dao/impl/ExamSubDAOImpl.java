package com.cbt.app.exams.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cbt.app.exams.dao.ExamSubDAO;
import com.cbt.app.exams.model.ExamSubDTO;

@Repository
public class ExamSubDAOImpl implements ExamSubDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "ExamSub.";

	/**모든 문제정보를 가져오는 메소드
	 *
	 */
	@Override
	public List<ExamSubDTO> getAllExamsubs() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getAllExamsubs");
	}

	/**하나의 시험정보를 가져오는 메소드
	 *
	 */
	@Override
	public ExamSubDTO getOneExamsub(ExamSubDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getOneExamsub",dto);
	}

	/**하나의 시험정보를 저장하는 메소드
	 *
	 */
	@Override
	public int insertNewExamsub(ExamSubDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(ns + "insertNewExamsub", dto);
	}
}
