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

/**시험 - [문제] - 문항 중 문제에 대한 내용*/
@Getter
@Setter
@ToString
public class ExamSubDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**문제 고유번호 */
	private int seq;
	private int seq_exam;		//시험 고유번호(FK)
	private double score;			//문제의 배점
	private String title;		//문제 title
	private String content;		//문제 상세설명(content) 또는 이미지 url
	private String ans_a;		//보기1 설명
	private String ans_b;		//보기2 설명
	private String ans_c;		//보기3 설명
	private String ans_d;		//보기4 설명
	private String ans_sbj;		//주관식 추가 설명
	private String right_answer;	//정답(1, 2, 3, 4, String answer)
	private Date rdate;			//등록일
	
	@Builder
	public ExamSubDTO() {}

	@Builder
	public ExamSubDTO(int seq, int seq_exam, double score, String title, String content, String ans_a, String ans_b,
			String ans_c, String ans_d, String ans_sbj, String right_answer, Date rdate) {
		super();
		this.seq = seq;
		this.seq_exam = seq_exam;
		this.score = score;
		this.title = title;
		this.content = content;
		this.ans_a = ans_a;
		this.ans_b = ans_b;
		this.ans_c = ans_c;
		this.ans_d = ans_d;
		this.ans_sbj = ans_sbj;
		this.right_answer = right_answer;
		this.rdate = rdate;
	}
}
/*

CREATE TABLE CBT_EXAM_SUB(
    SEQ NUMBER(10) NOT NULL PRIMARY KEY,
    SEQ_EXAM NUMBER(10),
    SCORE NUMBER(10),
    TITLE VARCHAR2(1000),
    CONTENT VARCHAR2(1000),
    ANS_A VARCHAR2(1000),
    ANS_B VARCHAR2(1000),
    ANS_C VARCHAR2(1000),
    ANS_D VARCHAR2(1000),
    ANS_SBJ VARCHAR2(1000),
    RIGHT_ANSWER VARCHAR2(1000),
    RDATE DATE
);

CREATE SEQUENCE SQE_CBT_EXAM_SUB START WITH 1 INCREMENT BY 1;

 */