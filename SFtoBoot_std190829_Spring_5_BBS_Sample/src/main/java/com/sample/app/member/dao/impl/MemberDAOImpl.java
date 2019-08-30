package com.sample.app.member.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.app.member.dao.MemberDAO;
import com.sample.app.member.model.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "Member.";
	
	@Override
	public boolean addmember(MemberDTO mem) throws Exception {
		// TODO Auto-generated method stub
		int n = sqlSession.insert(ns + "addmember", mem);		
		return n>0?true:false;
	}

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
