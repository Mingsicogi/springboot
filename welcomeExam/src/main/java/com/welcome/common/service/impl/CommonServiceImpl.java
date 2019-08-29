package com.welcome.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welcome.common.dao.CommonDao;
import com.welcome.common.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private CommonDao commonDao;
	
	@Override
	public int selectTest() {
		// TODO Auto-generated method stub
		return commonDao.selectTest();
	}
	
}
