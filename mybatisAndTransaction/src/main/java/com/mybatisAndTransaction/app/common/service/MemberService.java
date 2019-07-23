package com.mybatisAndTransaction.app.common.service;

import com.mybatisAndTransaction.app.common.vo.MemberVO;

/**
 * 멤버 관련 서비스 정의
 * 
 * @author minhj
 *
 */
public interface MemberService {
	public MemberVO getMemberOne(MemberVO member);
	
	public void addMember(MemberVO member);
}
