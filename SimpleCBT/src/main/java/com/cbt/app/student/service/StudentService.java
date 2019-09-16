package com.cbt.app.student.service;

import java.util.List;

import com.cbt.app.student.model.AttenderDTO;

public interface StudentService {
	/**한 학생의 모든 수강정보를 DB에서 가져오는 메소드
	 * @return
	 */
	public List<AttenderDTO> getAllAttendenceInfoOfOneStudent(int student_seq);
	
	/**한 학생의 특정 수강정보를 DB에서 가져오는 메소드
	 * @return
	 */
	public AttenderDTO getOneAttendenceInfoOfOneStudent(AttenderDTO dto);
}
