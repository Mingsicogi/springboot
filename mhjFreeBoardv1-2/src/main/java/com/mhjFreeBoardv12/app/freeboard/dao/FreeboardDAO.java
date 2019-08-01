package com.mhjFreeBoardv12.app.freeboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mhjFreeBoardv12.app.freeboard.vo.FreeboardVO;

@Repository
public class FreeboardDAO {
	private final String NAME_SPACE = "freeboard.";
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * @param param
	 * @return
	 * BBS DB에서 1개의 FreeboardVO 객체를 찾아, 리턴해주는 메소드
	 * PK seq로 찾는다.
	 */
	public FreeboardVO getOnePost(FreeboardVO param) {
		return sqlSession.selectOne(NAME_SPACE + "selectOnePost", param);
	}
	
	/**
	 * @return
	 * BBS DB에서 모든 row를 찾아 List 형태로 리턴 
	 */
	public List<FreeboardVO> getAllPost(){
		return sqlSession.selectList(NAME_SPACE + "selectAllPost");
	}
}
