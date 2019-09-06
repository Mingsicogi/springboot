package com.cbt.app.member.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private int seq;		//고유번호
	private String id;		//ID
	private String pw;		//PW
	private String name;	//이름
	private String email;	//email
	private int auth;		//학생(3)/교수자(2)/관리자(1)
	private Date rdate;		//가입일
}

/*

CREATE TABLE CBT_MEMBER(
    SEQ NUMBER(10) NOT NULL,
    ID VARCHAR2(1000),
    PW VARCHAR2(1000),
    NAME VARCHAR2(1000),
    EMAIL VARCHAR2(1000),
    AUTH NUMBER(10),
    RDATE DATE
);

CREATE SEQUENCE SEQ_CBT_MEMBER START WITH 1 INCREMENT BY 1;

*/