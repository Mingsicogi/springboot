package com.mybatisAndTransaction.app.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatisAndTransaction.app.common.service.AccessLogService;
import com.mybatisAndTransaction.app.common.service.dao.AccessLogDAO;
import com.mybatisAndTransaction.app.common.vo.AccessLogVO;

@Service
public class AccessLogServiceImpl implements AccessLogService {

	@Autowired
	private AccessLogDAO accessLogDAO;
	
	
	@Override
	public void saveAccessLog(AccessLogVO param) {		
		accessLogDAO.saveAccessLog(param);
	}

}
