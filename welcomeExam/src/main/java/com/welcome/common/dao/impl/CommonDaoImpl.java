package com.welcome.common.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.welcome.common.dao.CommonDao;

@Repository
public class CommonDaoImpl implements CommonDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int selectTest() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("admin.member.selectTest");
	}
	
}
