package com.cbt.app.student.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**어떤 과목(subject)에 어떤 수강생이 수강중인지에 대한 정보
 * @author minhj
 *
 */
@Getter
@Setter
@ToString
public class AttenderDTO implements Serializable {
	/**고유번호*/
	private int seq;
	/**과목번호*/
	private int subject_seq;
	/**학생번호(member seq)*/
	private int student_seq;

	@Builder
	public AttenderDTO() {}

	@Builder
	public AttenderDTO(int seq, int subject_seq, int student_seq) {
		super();
		this.seq = seq;
		this.subject_seq = subject_seq;
		this.student_seq = student_seq;
	}
}

/*

CREATE TABLE CBT_ATTENDER(
    SEQ NUMBER(10) PRIMARY KEY,
    SUBJECT_SEQ NUMBER(10),
    STUDENT_SEQ NUMBER(10)
);
CREATE SEQUENCE SEQ_CBT_ATTENDER START WITH 1 INCREMENT BY 1;

*/