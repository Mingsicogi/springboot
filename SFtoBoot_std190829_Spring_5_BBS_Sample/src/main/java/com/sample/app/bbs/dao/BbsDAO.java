package com.sample.app.bbs.dao;

import java.util.List;

import com.sample.app.bbs.model.BbsDTO;
import com.sample.app.bbs.model.BbsParam;


public interface BbsDAO {
	
	public List<BbsDTO> getBbsList(BbsParam param);
	
	public int getBbsCount(BbsParam param);	
}
