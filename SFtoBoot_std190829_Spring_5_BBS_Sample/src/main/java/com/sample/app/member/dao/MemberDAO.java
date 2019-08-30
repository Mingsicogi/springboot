package com.sample.app.member.dao;

import com.sample.app.member.model.MemberDTO;

public interface MemberDAO {

	public boolean addmember(MemberDTO mem)throws Exception;
	
	public int getId(MemberDTO mem);
	
	public MemberDTO login(MemberDTO mem);
}
