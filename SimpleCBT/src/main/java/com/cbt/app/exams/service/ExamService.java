package com.cbt.app.exams.service;

import java.util.List;
import java.util.Map;

import com.cbt.app.exams.model.ExamConditionDTO;
import com.cbt.app.exams.model.ExamDTO;

public interface ExamService {
	
	/**모든 시험정보를 가져오는 메소드
	 * @return
	 */
	public List<ExamConditionDTO> getAllExams();
		
	/**하나의 시험정보를 가져오는 메소드
	 * @param dto
	 * @return
	 */
	public ExamConditionDTO getOneExam(ExamConditionDTO dto);
	
	/**하나의 시험정보를 저장하는 메소드
	 * @param dto
	 * @return
	 */
	public int insertNewExam(ExamConditionDTO dto);
	
	/**seq에 맞는 exam 1개를 DB에서 가져오는 메소드
	 * @param seq
	 * @return
	 */
	public ExamDTO getOneExamBySeq(int seq);
	
	/**subject 번호에 맞는 exam들을 모두 가져오는 메소드
	 * @param subjectSeq
	 * @return
	 */
	public List<ExamDTO> getExamsBySubjectSeq(int subjectSeq);
}
