package com.minhjFreeBoard.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.minhjFreeBoard.model.dao.FreeBoardDAO;
import com.minhjFreeBoard.model.dto.PostsDTO;
import com.minhjFreeBoard.service.FreeBoardService;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Inject
	FreeBoardDAO freeBoardDAO;
	
	@Override
	public List<PostsDTO> list() {
		// TODO Auto-generated method stub
		return freeBoardDAO.list();
	}

}
