package com.sse.app.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sse.app.member.model.Account;
import com.sse.app.member.model.AccountMapper;

@Repository
public class AccountRepository {
	
	@Autowired
	private AccountMapper accountMapper;
	
	public Account save(Account account,String role){
		accountMapper.insertUser(account);
		accountMapper.insertUserAutority(account.getUsername(), role);
		return account;
	}

	public Account findById(String username) {
		// TODO Auto-generated method stub
		return accountMapper.readAccount(username);
	}
	
	public List<?> findauthoritiesbyid(String username){
		return accountMapper.readAuthorities(username);
	}
}
