package com.cbt.app.exams.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**[시험] - 문제 - 문항 중 시험 대한 내용
 * -> ExamConditionDTO를 사용 */
@Getter
@Setter
@ToString
public class ExamDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int seq;
	private int subject;	//과목 고유코드. CBT_SUBJECT의 SEQ값
	private int teacher;	//출제자 코드
	private String title;	//시험 이름
	private int limit_time;	//제한시간(m)
	private String rdate;		//등록일
	private String sdate;		//시작일
	private String edate;		//종료일	
	
	@Builder
	public ExamDTO() { }

	@Builder
	public ExamDTO(int seq, int subject, int teacher, String title, int limit_time, String rdate, String sdate,
			String edate) {
		super();
		this.seq = seq;
		this.subject = subject;
		this.teacher = teacher;
		this.title = title;
		this.limit_time = limit_time;
		this.rdate = rdate;
		this.sdate = sdate;
		this.edate = edate;
	}	
}

/*
CREATE TABLE CBT_EXAM(
    SEQ NUMBER(10) NOT NULL PRIMARY KEY,
    SUBJECT NUMBER(10),
    TEACHER NUMBER(10),
    TITLE VARCHAR2(1000),
    LIMIT_TIME NUMBER(20),
    RDATE DATE,
    SDATE DATE,
    EDATE DATE
);

CREATE SEQUENCE SQE_CBT_EXAM START WITH 1 INCREMENT BY 1;
*/