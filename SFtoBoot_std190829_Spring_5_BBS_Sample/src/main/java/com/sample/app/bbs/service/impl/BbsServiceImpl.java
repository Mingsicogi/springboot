package com.sample.app.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.app.bbs.dao.BbsDAO;
import com.sample.app.bbs.model.BbsDTO;
import com.sample.app.bbs.model.BbsParam;
import com.sample.app.bbs.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDAO bbsDAO;
	
	@Override
	public List<BbsDTO> getBbsList(BbsParam param) {
		// TODO Auto-generated method stub
		return bbsDAO.getBbsList(param);
	}

	@Override
	public int getBbsCount(BbsParam param) {
		// TODO Auto-generated method stub
		return bbsDAO.getBbsCount(param);
	}

}
