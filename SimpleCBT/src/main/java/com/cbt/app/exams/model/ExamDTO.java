package com.cbt.app.exams.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**[시험] - 문제 - 문항 중 시험 대한 내용 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {
	private int seq;
	private int subject;	//과목코드. 국어101, 영어102, 수학201, 등
	private int propesser;	//출제자 코드
	private String title;	//시험 이름
	private int limit_time;	//제한시간(s)
	private Date rdate;		//등록일
	private Date sdate;		//시작일
	private Date edate;		//종료일	
}

/*
CREATE TABLE CBT_EXAM(
    SEQ NUMBER(10) NOT NULL PRIMARY KEY,
    SUBJECT NUMBER(10),
    PROPESSER NUMBER(10),
    TITLE VARCHAR2(1000),
    LIMIT_TIME NUMBER(20),
    RDATE DATE,
    SDATE DATE,
    EDATE DATE
);

CREATE SEQUENCE SQE_CBT_EXAM START WITH 1 INCREMENT BY 1;
*/