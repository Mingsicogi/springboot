package com.sample.app.bbs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.app.bbs.dao.BbsDAO;
import com.sample.app.bbs.model.BbsDTO;
import com.sample.app.bbs.model.BbsParam;

@Repository
public class BbsDAOImpl implements BbsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "Bbs.";
	
	@Override
	public List<BbsDTO> getBbsList(BbsParam param) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getBbsList", param);
	}

	@Override
	public int getBbsCount(BbsParam param) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getBbsCount", param);
	}

}
