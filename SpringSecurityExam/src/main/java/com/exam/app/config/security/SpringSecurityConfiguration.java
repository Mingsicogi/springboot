package com.exam.app.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	private final String LOGIN_PAGE_URI = "/logingo";
	
	/**
     * 인증 설정 관련.
     *
     * @param auth
     * @throws Exception
     */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new BCryptPasswordEncoder())
		;
	}

	/**
     * security filter와 연결하기 위한 설정 관련.
     *
     * @param web
     * @throws Exception
     */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 해당 패턴은 security filter 제외
		web.ignoring().antMatchers("/favicon.ico", "/css/**", "/image/**", "/js/**", "/webjars/**");
	}

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
		 		.antMatchers("/member","/member/*").authenticated()
		 		.antMatchers("/logingo","/logingo/*").authenticated()
		 		.antMatchers("/login","/login/*").authenticated()
		 		.anyRequest().permitAll()
		 		.and()
		 	.formLogin()
		 		.loginPage(LOGIN_PAGE_URI)
		 		.permitAll()
		 		.defaultSuccessUrl("/welcome")
		 		.and()
		 	.logout()
		 		.logoutUrl("/logout")
		 		.logoutSuccessUrl(LOGIN_PAGE_URI)
		 		.invalidateHttpSession(true)
		 		.permitAll();
		
	}
	
	@Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }
	
}
