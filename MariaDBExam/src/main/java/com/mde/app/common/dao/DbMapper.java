package com.mde.app.common.dao;

import java.util.List;

import com.mde.app.common.model.TestDTO;

public interface DbMapper {
	public List<TestDTO> getList() throws Exception;
}
