package com.sample.app.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.app.member.dao.MemberDAO;
import com.sample.app.member.model.MemberDTO;
import com.sample.app.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public boolean addmember(MemberDTO mem) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.addmember(mem);
	}

	@Override
	public int getId(MemberDTO mem) {
		// TODO Auto-generated method stub
		return memberDAO.getId(mem);
	}

	@Override
	public MemberDTO login(MemberDTO mem) {
		// TODO Auto-generated method stub
		return memberDAO.login(mem);
	}
		

}
