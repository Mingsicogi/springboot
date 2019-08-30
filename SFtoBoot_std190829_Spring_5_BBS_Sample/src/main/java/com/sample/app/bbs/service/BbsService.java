package com.sample.app.bbs.service;

import java.util.List;

import com.sample.app.bbs.model.BbsDTO;
import com.sample.app.bbs.model.BbsParam;

public interface BbsService {

	public List<BbsDTO> getBbsList(BbsParam param);
	
	public int getBbsCount(BbsParam param);
}
