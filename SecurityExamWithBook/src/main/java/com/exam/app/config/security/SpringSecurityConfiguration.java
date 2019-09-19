package com.exam.app.config.security;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.exam.app.security.CustomLoginSuccessHandler;
import com.exam.app.security.CustomLogoutSuccessHandler;
import com.exam.app.security.CustomUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;	
	@Autowired
	private PasswordEncoder pwe;
	
	/**
     * request를 안전하게 보호하기 위한 설정 관련.
     *
     * @param http
     * @throws Exception
     */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 	.authorizeRequests()
		 		.antMatchers("/welcome").permitAll()
		 		.antMatchers("/exam/all", "/exam/all/*").permitAll()
		 		.antMatchers("/exam/admin","/exam/admin/*").access("hasRole('ROLE_ADMIN')")
		 		//.antMatchers("/exam/admin","/exam/admin/*").permitAll()
		 		.antMatchers("/exam/member","/exam/member/*").access("hasRole('ROLE_MEMBER')");
		 http
		 	.formLogin()
		 		.loginPage("/customlogin")
		 		.loginProcessingUrl("/login")
		 		.successHandler(loginSuccessHandler());
		 
//		 http
//		 	.logout()
//		 		.logoutUrl("/customlogout")
//		 		.invalidateHttpSession(true)
//		 		.deleteCookies("remember-me","JSESSION_ID")
//		 		.logoutSuccessHandler(logoutSuccessHandler());
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("configure............................");
		
		//테스트를 위한 기본 멤버 설정
//		auth
//			.inMemoryAuthentication()
//				.withUser("admin").password("{noop}admin").roles("ADMIN");
//		auth
//			.inMemoryAuthentication()
//				.withUser("member").password("{noop}member").roles("MEMBER");
//		
//		String queryUser = "SELECT ID, PW, ENABLED FROM MEMBER_TEST WHERE ID=?";
//		String queryDetails = "SELECT ID, AUTH FROM AUTH_TEST WHERE ID=?";
//		
//		auth
//			.jdbcAuthentication()
//				.dataSource(dataSource)
//				.passwordEncoder(pwe)
//				.usersByUsernameQuery(queryUser)
//				.authoritiesByUsernameQuery(queryDetails);
		auth.userDetailsService(customUserService()).passwordEncoder(pwe);
	}


	/**로그인 성공 핸들러 설정
	 * @return
	 */
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}
	
	@Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }
	
	/**비밀번호 암호화 설정
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailsService();
	}
	
}
