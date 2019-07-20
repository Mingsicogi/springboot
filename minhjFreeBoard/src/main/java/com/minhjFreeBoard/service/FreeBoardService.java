package com.minhjFreeBoard.service;

import java.util.List;

import com.minhjFreeBoard.model.dto.PostsDTO;

public interface FreeBoardService {
	public List<PostsDTO> list();
	
	public void insert(PostsDTO dto);
}
