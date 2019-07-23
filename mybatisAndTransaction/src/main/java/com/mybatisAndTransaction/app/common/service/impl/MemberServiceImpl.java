package com.mybatisAndTransaction.app.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatisAndTransaction.app.common.service.MemberService;
import com.mybatisAndTransaction.app.common.service.dao.MemberDAO;
import com.mybatisAndTransaction.app.common.vo.MemberVO;

/**
 * 멤버 객체 관련 서비스 구현
 * 
 * @author minhj
 *
 */
@Service
public class MemberServiceImpl implements MemberService{
	
	

	@Autowired
	private MemberDAO memberDAO;

	/**
	 * 유니크 키로 단건 멤버 정보를 조회하는 메소드
	 *
	 * return MemberVO
	 */
	@Override
	public MemberVO getMemberOne(MemberVO member) {
		return memberDAO.getMemberOne(member);
	}

	@Override
	public void addMember(MemberVO member) {
		memberDAO.insertMemberOne(member);
		
	}
}
