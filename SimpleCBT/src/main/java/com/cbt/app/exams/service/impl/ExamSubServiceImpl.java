package com.cbt.app.exams.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.app.exams.dao.ExamSubDAO;
import com.cbt.app.exams.model.ExamSubDTO;
import com.cbt.app.exams.service.ExamSubService;

@Service
public class ExamSubServiceImpl implements ExamSubService {

	@Autowired
	private ExamSubDAO examSubDAO;
	
	@Override
	public List<ExamSubDTO> getAllExamsubs() {
		// TODO Auto-generated method stub
		return examSubDAO.getAllExamsubs();
	}

	@Override
	public ExamSubDTO getOneExamsub(ExamSubDTO dto) {
		// TODO Auto-generated method stub
		return examSubDAO.getOneExamsub(dto);
	}

	@Override
	public int insertNewExamsub(ExamSubDTO dto) {
		// TODO Auto-generated method stub
		return examSubDAO.insertNewExamsub(dto);
	}
	
}
