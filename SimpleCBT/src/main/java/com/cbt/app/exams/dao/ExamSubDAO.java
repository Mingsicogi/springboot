package com.cbt.app.exams.dao;

import java.util.List;

import com.cbt.app.exams.model.ExamSubDTO;

public interface ExamSubDAO {
	/**모든 문제정보를 가져오는 메소드
	 * @return
	 */
	public List<ExamSubDTO> getAllExamsubs();
		
	/**하나의 시험정보를 가져오는 메소드
	 * @param dto
	 * @return
	 */
	public ExamSubDTO getOneExamsub(ExamSubDTO dto);
	
	/**하나의 시험정보를 저장하는 메소드
	 * @param dto
	 * @return
	 */
	public int insertNewExamsub(ExamSubDTO dto);
}
