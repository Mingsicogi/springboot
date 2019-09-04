package com.sample.app.pds.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.app.pds.dao.PdsDAO;
import com.sample.app.pds.model.PdsDTO;
import com.sample.app.pds.model.PdsOrderOption;

@Repository
public class PdsDAOImpl implements PdsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "Pds.";
	
	@Override
	public List<PdsDTO> getPdsList(PdsOrderOption option) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getPdsList", option);
	}

	@Override
	public PdsDTO getOnePds(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getPdsDetail", seq);
	}

	@Override
	public int uploadPds(PdsDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(ns + "uploadPds", dto);
	}

	@Override
	public int plusDownCount(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.update(ns + "plusDownCount", seq);
	}

	@Override
	public int getTotalSize(PdsOrderOption option) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getTotalSize", option);
	}
	
}
