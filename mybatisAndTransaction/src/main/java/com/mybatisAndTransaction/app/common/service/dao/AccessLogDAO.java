package com.mybatisAndTransaction.app.common.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatisAndTransaction.app.common.vo.AccessLogVO;

@Repository
public class AccessLogDAO {
	
	private final String NAME_SPACE = "admin.freeboardAccessLog.";
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 접속자 정보를 매개변수로 받아서 접속자 ID를 로그DB에 저장
	 * @param param
	 */
	public void saveAccessLog(AccessLogVO param) {
		sqlSession.selectOne(NAME_SPACE + "insertAccessLog", param);
	}
}
