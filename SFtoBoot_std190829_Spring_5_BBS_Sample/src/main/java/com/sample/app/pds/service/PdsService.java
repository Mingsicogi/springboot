package com.sample.app.pds.service;

import java.util.List;

import com.sample.app.pds.model.PdsDTO;
import com.sample.app.pds.model.PdsOrderOption;

public interface PdsService {
	public List<PdsDTO> getPdsList(PdsOrderOption option);

	public PdsDTO getOnePds(int seq);

	public int uploadPds(PdsDTO dto);

	public int plusDownCount(int seq);
	
	public int getTotalSize(PdsOrderOption option);
}
