package com.cbt.app.exams.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.app.exams.dao.SubjectDAO;
import com.cbt.app.exams.model.SubjectDTO;
import com.cbt.app.exams.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectDAO subjectDAO;

	@Override
	public List<SubjectDTO> getAllSubject() {
		// TODO Auto-generated method stub
		return subjectDAO.getAllSubject();
	}

	@Override
	public List<SubjectDTO> getSubjectsByTeacherNum(int seq) {
		// TODO Auto-generated method stub
		return subjectDAO.getSubjectsByTeacherNum(seq);
	}
	/**매개변수 seq에 해당하는 특정 과목정보 리턴
	 * @param seq
	 * @return
	 */
	@Override
	public SubjectDTO getSubjectBySeq(int seq) {
		// TODO Auto-generated method stub
		return subjectDAO.getSubjectBySeq(seq);
	}	
	
}
