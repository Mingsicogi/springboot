package com.cbt.app.member.dao;

import java.util.List;

import com.cbt.app.member.model.MemberDTO;

public interface MemberDAO {
	
	public List<MemberDTO> getAllMember();
	
	public int addTeacher(MemberDTO mem);

	public int addStudent(MemberDTO mem);

	public int getId(MemberDTO mem);
	
	public MemberDTO login(MemberDTO mem);
}
