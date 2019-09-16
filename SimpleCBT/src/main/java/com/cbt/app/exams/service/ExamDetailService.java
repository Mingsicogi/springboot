package com.cbt.app.exams.service;

import com.cbt.app.exams.model.ExamResultDTO;

public interface ExamDetailService {
	/**특정 시험의 응시문항 수 리턴
	 * @param seq_exam
	 * @return
	 */
	public ExamResultDTO getExamDetailCount(int seq_exam);
	
	/**특정 시험의 총점 리턴
	 * @param seq_exam
	 * @return
	 */
	public double getExamDetailSum(int seq_exam);
}
