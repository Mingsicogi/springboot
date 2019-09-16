package com.cbt.app.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.app.member.dao.MemberDAO;
import com.cbt.app.member.model.MemberDTO;
import com.cbt.app.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<MemberDTO> getAllMember(){
		return memberDAO.getAllMember();
	}
	
	@Override
	public int addTeacher(MemberDTO mem) {
		// TODO Auto-generated method stub
		return memberDAO.addTeacher(mem);
	}

	@Override
	public int addStudent(MemberDTO mem) {
		// TODO Auto-generated method stub
		return memberDAO.addStudent(mem);
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
