package com.sample.app.member.service;

import com.sample.app.member.model.MemberDTO;

public interface MemberService {
	
	public boolean addmember(MemberDTO mem) throws Exception;
	
	public int getId(MemberDTO mem);
	
	public MemberDTO login(MemberDTO mem);
}
