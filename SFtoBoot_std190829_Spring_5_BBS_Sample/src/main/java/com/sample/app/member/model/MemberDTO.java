package com.sample.app.member.model;

/*

DROP TABLE MEMBER
CASCADE CONSTRAINTS;

CREATE TABLE MEMBER(
	ID VARCHAR2(50) PRIMARY KEY,
	PWD VARCHAR2(50) NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	EMAIL VARCHAR2(50) UNIQUE,
	AUTH NUMBER(1) NOT NULL
);

*/

import java.io.Serializable;

import org.springframework.stereotype.Service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO implements Serializable{
	//ID, PW, NAME, EMAIL, AUTH)
	private String id;
	private String pw;
	private String name;
	private String email;
	private int auth;		// 사용자(3)/관리자(1)
	
	@Builder
	public MemberDTO() {	}

	@Builder
	public MemberDTO(String id, String pw, String name, String email, int auth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.auth = auth;
	}
}
