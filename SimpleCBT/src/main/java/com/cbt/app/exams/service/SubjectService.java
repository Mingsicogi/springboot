package com.cbt.app.exams.service;

import java.util.List;

import com.cbt.app.exams.model.SubjectDTO;

public interface SubjectService {
	/**모든 과목정보 리턴
	 * @return
	 */
	public List<SubjectDTO> getAllSubject();
		
	/**매개변수 교수자가 갖는 모든 과목정보 리턴
	 * @param seq
	 * @return
	 */
	public List<SubjectDTO> getSubjectsByTeacherNum(int seq);
	
	/**매개변수 seq에 해당하는 특정 과목정보 리턴
	 * @param seq
	 * @return
	 */
	public SubjectDTO getSubjectBySeq(int seq);
}
