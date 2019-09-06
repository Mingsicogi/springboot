package com.cbt.app.exams.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**시험 - [문제] - 문항 중 문제에 대한 내용*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamSubDTO {	
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