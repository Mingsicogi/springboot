package com.exam.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.exam.app.common.dao.CommonDAO;
import com.exam.app.common.model.TestDTO;
import com.exam.app.security.domain.CustomUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CommonDAO commonDAO;
	
//	@Setter(onMethod_ = {@Autowired})
//	private CommonDAO commonDAO;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By UserName : " + username);
		
		TestDTO dto = commonDAO.read(username);
		
		log.warn("queried by member mapper: " + dto);
		
		return dto == null ? null : new CustomUser(dto);
	}	
}
