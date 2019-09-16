package com.cbt.app.student.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cbt.app.student.dao.StudentDAO;
import com.cbt.app.student.model.AttenderDTO;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "Student.";
	
	/**한 학생의 모든 수강정보를 DB에서 가져오는 메소드
	 *
	 */
	@Override
	public List<AttenderDTO> getAllAttendenceInfoOfOneStudent(int student_seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getAllAttendenceInfoOfOneStudent", student_seq);
	}

	/**한 학생의 특정 수강정보를 DB에서 가져오는 메소드
	 *
	 */
	@Override
	public AttenderDTO getOneAttendenceInfoOfOneStudent(AttenderDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getOneAttendenceInfoOfOneStudent", dto);
	}

}
