package com.cbt.app.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.app.student.dao.StudentDAO;
import com.cbt.app.student.model.AttenderDTO;
import com.cbt.app.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<AttenderDTO> getAllAttendenceInfoOfOneStudent(int student_seq) {
		// TODO Auto-generated method stub
		return studentDAO.getAllAttendenceInfoOfOneStudent(student_seq);
	}

	@Override
	public AttenderDTO getOneAttendenceInfoOfOneStudent(AttenderDTO dto) {
		// TODO Auto-generated method stub
		return studentDAO.getOneAttendenceInfoOfOneStudent(dto);
	}
	
	
}
