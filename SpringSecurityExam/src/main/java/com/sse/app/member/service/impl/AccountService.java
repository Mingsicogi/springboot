package com.sse.app.member.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sse.app.member.dao.AccountRepository;
import com.sse.app.member.model.Account;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Account account = accountRepository.findById(username);
		account.setAuthorities(account.getAuthorities());
		UserDetails userDetails=new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return account.getUsername();
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return account.getPassword();
			}
			
			@Override
			public Collection <? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
				
				return account.getAuthorities();
			}
		};
		
		return null;
	}

	public Collection<GrantedAuthority> getAuthorities(String username) {
		Account accounts = new Account();
		List<String> string_authorities = accounts.findAuthoritiesByID(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String authority : string_authorities) {
			authorities.add(new SimpleGrantedAuthority(authority));
		}
		return authorities;
	}

}

