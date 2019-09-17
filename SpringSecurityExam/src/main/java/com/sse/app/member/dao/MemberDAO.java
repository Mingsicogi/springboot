package com.sse.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sse.app.member.model.MemberUserDetails;

@Repository("memberDAO")
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public MemberUserDetails getUserById(String id) {
		return sqlSession.selectOne("member.selectUserById", id);
	}
}
