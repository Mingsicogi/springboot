package com.sample.app.pds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.app.pds.dao.PdsDAO;
import com.sample.app.pds.model.PdsDTO;
import com.sample.app.pds.model.PdsOrderOption;
import com.sample.app.pds.service.PdsService;

@Service
public class PdsServiceImpl implements PdsService {

	@Autowired
	private PdsDAO pdsDAO;
	
	
	@Override
	public List<PdsDTO> getPdsList(PdsOrderOption option) {
		// TODO Auto-generated method stub
		return pdsDAO.getPdsList(option);
	}


	@Override
	public PdsDTO getOnePds(int seq) {
		// TODO Auto-generated method stub
		return pdsDAO.getOnePds(seq);
	}


	@Override
	public int uploadPds(PdsDTO dto) {
		// TODO Auto-generated method stub
		return pdsDAO.uploadPds(dto);
	}


	@Override
	public int plusDownCount(int seq) {
		// TODO Auto-generated method stub
		return pdsDAO.plusDownCount(seq);
	}

	@Override
	public int getTotalSize(PdsOrderOption option) {
		// TODO Auto-generated method stub
		return pdsDAO.getTotalSize(option);
	}	
}
