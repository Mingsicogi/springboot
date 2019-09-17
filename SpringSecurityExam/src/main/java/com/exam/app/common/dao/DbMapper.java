package com.exam.app.common.dao;

import java.util.List;

import com.exam.app.common.model.TestDTO;

public interface DbMapper {
	public List<TestDTO> getList() throws Exception;
}
