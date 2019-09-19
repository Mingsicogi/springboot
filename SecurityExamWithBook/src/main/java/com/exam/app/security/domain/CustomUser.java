package com.exam.app.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.exam.app.common.model.TestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CustomUser extends User {
		
	private TestDTO dto;	

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	public CustomUser(TestDTO dto) {
		super(dto.getUserid(), dto.getUserpw(), dto.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.dto = dto;
	}
	
}
