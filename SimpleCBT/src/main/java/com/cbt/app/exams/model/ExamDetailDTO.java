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

/**시험 - 문제 - [문항] 중 문항 대한 내용 */
@Getter
@Setter
@ToString
public class ExamDetailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	/**고유번호*/
	private int seq;	
	/**시험 고유번호(FK)*/
	private int seq_exam;
	/**문제 고유번호(FK)*/
	private int seq_exam_sub;
	/**응시자 고유번호(FK)*/
	private int seq_student;
	/**득점 스코어. 오답은 0 */
	private double score;
	/**응답한 내용(고른 보기, 제출한 단답형 답안)*/
	private String answer;
	/**등록일*/
	private Date rdate;
	
	@Builder
	public ExamDetailDTO() { }

	@Builder
	public ExamDetailDTO(int seq, int seq_exam, int seq_exam_sub, int seq_student, double score, String answer,
			Date rdate) {
		super();
		this.seq = seq;
		this.seq_exam = seq_exam;
		this.seq_exam_sub = seq_exam_sub;
		this.seq_student = seq_student;
		this.score = score;
		this.answer = answer;
		this.rdate = rdate;
	}
}
/*
CREATE TABLE CBT_EXAM_DETAIL(
    SEQ NUMBER(10) NOT NULL PRIMARY KEY,
    SEQ_EXAM NUMBER(10),
    SEQ_EXAM_SUB NUMBER(10),
    SEQ_STUDENT NUMBER(10),
    SCORE NUMBER(10),
    ANSWER VARCHAR2(4000),
    RDATE DATE
);

CREATE SEQUENCE SQE_CBT_EXAM_DETAIL START WITH 1 INCREMENT BY 1;

*/