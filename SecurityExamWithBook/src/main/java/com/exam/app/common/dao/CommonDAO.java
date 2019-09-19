package com.exam.app.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.app.common.model.TestDTO;

@Repository
public class CommonDAO {

	@Autowired
	private SqlSession ss;
	
	public TestDTO read(String username) {
		return ss.selectOne("common.read", username);
	}
}
