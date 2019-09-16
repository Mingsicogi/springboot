package com.cbt.app.exams.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamResultDTO implements Serializable {	
	private static final long serialVersionUID = 1L;
	private int student_seq;	//응시한 학생의 고유번호(seq)
	private int exam_seq;		//응시한 시험의 고유번호
	private double score_sum;	//응시한 시험의 총 점수
	private int score_count;	//응시한 시험에서의 문항 수
	
	@Builder
	public ExamResultDTO() {}

	@Builder
	public ExamResultDTO(int student_seq, int exam_seq, double score_sum, int score_count) {
		super();
		this.student_seq = student_seq;
		this.exam_seq = exam_seq;
		this.score_sum = score_sum;
		this.score_count = score_count;
	}
}
