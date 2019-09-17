package com.sse.app.member.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
	
	@Select("SELECT * FROM SEC_MEMBER WHERE username=#{username}")
	public Account readAccount(String username);
	
	@Select("SELECT authority_name FROM SEC_AUTHORITY WHERE username=#{id}")
	public List<?> readAuthorities(String id);
	
	@Select("SELECT * FROM SEC_MEMBER")
	public List<?> readAllUsers();
	
	@Insert("INSERT INTO SEC_MEMBER VALUES(#{account.username},#{account.password},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled})")
	public void insertUser(@Param("account") Account account);
	
	@Insert("INSERT INTO SEC_AUTHORITY VALUES(#{username},#{autority})")
	public void insertUserAutority(@Param("username") String username,@Param("autority")String autority);
}
