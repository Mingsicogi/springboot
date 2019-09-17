package com.sse.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MemberAuthenticationProvider memberAuthenticationProvider;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/img/**").permitAll()
	        .antMatchers("/auth/admin/**").hasRole("ADMIN") // 내부적으로 접두어 "ROLE_"가 붙는다.
	        .antMatchers("/auth/**").hasAnyRole("ADMIN", "USER") // 내부적으로 접두어 "ROLE_"가 붙는다.
	        .anyRequest().authenticated();
		
		http.formLogin()
			.loginPage("/login") // default
            .loginProcessingUrl("/authenticate")
            .failureUrl("/login?error") // default
            .defaultSuccessUrl("/home")
            .usernameParameter("email")
            .passwordParameter("password")
            .permitAll();
	}
	
}
