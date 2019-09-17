package com.exam.app.config.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**Authentication 구현 부분
 * 
 * @author minhj
 *
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	/**인증 관련 로직
	 *
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String userId = authentication.getName();
		String userPw = authentication.getCredentials() + "";
		
		
		if( "mhj".equals(userId) && "mhj".equals(userPw) ) {
			return new UsernamePasswordAuthenticationToken(userId, userPw, new HashSet<>(this.makeGrantedAuthority()));
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<GrantedAuthority> makeGrantedAuthority() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        return authorities;
    }

}
