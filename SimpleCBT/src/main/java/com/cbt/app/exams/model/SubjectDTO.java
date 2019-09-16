package com.cbt.app.exams.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class SubjectDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int seq;	//고유번호
	private int subject_serial;	//과목 구분번호(언어계열100, 자연과학계열200, 공학기술300...)
	private String subject;	//과목명
	private int teacher;	//담당선생 고유번호
	private String sdate;	//과목 시작일
	private String edate;	//과목 종료일
	private String rdate;	//과목 등록일
		
	@Builder
	public SubjectDTO() { }

	@Builder
	public SubjectDTO(int seq, int subject_serial, String subject, int teacher, String sdate, String edate,
			String rdate) {
		super();
		this.seq = seq;
		this.subject_serial = subject_serial;
		this.subject = subject;
		this.teacher = teacher;
		this.sdate = sdate;
		this.edate = edate;
		this.rdate = rdate;
	}	
}


/*
국어 101, 영어 102, 중국어 103
수학 201, 통계학202, 물리학203
컴퓨터공학 301, 기계공학 302
 

CREATE TABLE CBT_SUBJECT(
    SEQ NUMBER(10) PRIMARY KEY,
    SUBJECT_SERIAL NUMBER(10),
    SUBJECT VARCHAR2(1000),
    TEACHER NUMBER(10),
    SDATE DATE,
    EDATE DATE,
    RDATE DATE
);

CREATE SEQUENCE SEQ_CBT_SUBJECT START WITH 1 INCREMENT BY 1;


*/