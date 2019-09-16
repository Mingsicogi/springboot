package com.cbt.app.member.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cbt.app.member.dao.MemberDAO;
import com.cbt.app.member.model.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "Member.";
	
	/**모든 멤버 리스트로 가져오기
	 *
	 */
	@Override
	public List<MemberDTO> getAllMember(){
		return sqlSession.selectList(ns + "getAllMember");
	}
	
	/**새 교수자 등록
	 *
	 */
	@Override
	public int addTeacher(MemberDTO mem) {
		// TODO Auto-generated method stub
		return sqlSession.insert(ns + "addTeacher", mem);
	}
	
	/**새 학생 등록
	 *
	 */
	@Override
	public int addStudent(MemberDTO mem) {
		// TODO Auto-generated method stub
		return sqlSession.insert(ns + "addStudent", mem);
	}

	/** 아이디가 있으면 1리턴, 없으면 0 리턴
	 *
	 */
	@Override
	public int getId(MemberDTO mem) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getId", mem);
	}

	@Override
	public MemberDTO login(MemberDTO mem) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "login", mem);
	}
}
