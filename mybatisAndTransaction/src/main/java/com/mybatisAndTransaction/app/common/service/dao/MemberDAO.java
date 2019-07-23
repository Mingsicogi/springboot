package com.mybatisAndTransaction.app.common.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatisAndTransaction.app.common.vo.MemberVO;

@Repository
public class MemberDAO {
	
	//매핑된 xml의 namespace를 명시(src/main/resources/mapper/admin/adminMember.xml)
	private final String NAME_SPACE = "admin.member.";
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * @param param
	 * db에서 param의 email을 통해 한 건의 data를 찾아서 vo형태로 리턴
	 * @return
	 */
	public MemberVO getMemberOne(MemberVO param) {
		return sqlSession.selectOne(NAME_SPACE + "selectMemberOne", param);
	}
	
	/**
	 * @param param
	 * MemberVO타입의 데이터를 DB에 저장
	 * @return
	 */
	public int insertMemberOne(MemberVO param) {
		return sqlSession.insert(NAME_SPACE + "insertMemberOne", param);
	}
}
