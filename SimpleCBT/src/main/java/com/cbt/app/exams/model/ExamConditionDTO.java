package com.cbt.app.exams.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**[시험]-문제-문항
 * 시험에 대한 내용을 저장하기 위한 DTO
 * @author minhj
 *
 */
@Getter
@Setter
@ToString
public class ExamConditionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**시험 고유번호*/
	private int seq;
	/**과목 고유번호.*/
	private int subject;	
	/**과목 구분번호(언어계열100, 자연과학계열200, 공학기술300...)*/
	private int subject_serial;
	/**출제자 코드(seq_cbt_member)*/
	private int teacher;
	/**시험 이름. (ex_2019 영어 기말고사)*/
	private String title;
	/**시험 제한시간.*/
	private int limit_time;
	/**문제의 개수*/
	private int numberOfQuestions;
	/**시험 총점(ex_100점, 50점 등)*/
	private int amountOfScore;
	/**시험 시작일*/
	private String sdate;
	/**시험 종료일*/
	private String edate;
	
	/**시험 등록일*/
	private String rdate;
	
	@Builder
	public ExamConditionDTO() {	}

	@Builder
	public ExamConditionDTO(int seq, int subject, int subject_serial, int teacher, String title, int limit_time,
			int numberOfQuestions, int amountOfScore, String sdate, String edate, String rdate) {
		super();
		this.seq = seq;
		this.subject = subject;
		this.subject_serial = subject_serial;
		this.teacher = teacher;
		this.title = title;
		this.limit_time = limit_time;
		this.numberOfQuestions = numberOfQuestions;
		this.amountOfScore = amountOfScore;
		this.sdate = sdate;
		this.edate = edate;
		this.rdate = rdate;
	}	
}
