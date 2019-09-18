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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.exam.app.security.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;	
	@Autowired
	private PasswordEncoder pwe;
	
	private Logger log = LoggerFactory.getLogger(SpringSecurityConfiguration.class);
	
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
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("configure............................");
		//테스트를 위한 기본 멤버 설정
		auth
			.inMemoryAuthentication()
				.withUser("admin").password("{noop}admin").roles("ADMIN");
		auth
			.inMemoryAuthentication()
				.withUser("member").password("{noop}member").roles("MEMBER");
		
		String queryUser = "SELECT ID, PW, ENABLED FROM MEMBER_TEST WHERE ID=?";
		String queryDetails = "SELECT ID, AUTH FROM AUTH_TEST WHERE ID=?";
		
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(pwe)
				.usersByUsernameQuery(queryUser)
				.authoritiesByUsernameQuery(queryDetails);				
	}


	/**로그인 성공 핸들러 설정
	 * @return
	 */
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
