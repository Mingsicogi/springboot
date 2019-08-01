package com.mhjFreeBoardv12.app.freeboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhjFreeBoardv12.app.freeboard.dao.FreeboardDAO;
import com.mhjFreeBoardv12.app.freeboard.service.FreeboardService;
import com.mhjFreeBoardv12.app.freeboard.vo.FreeboardVO;

/**
 *	Freeboard 객체 관련 서비스 구현
 */
@Service
public class FreeboardServiceImpl implements FreeboardService {

	@Autowired
	private FreeboardDAO freeboardDAO;
	
	/**
	 * PK를 통해 단건 게시물 정보를 받아오는 메소드
	 */
	@Override
	public FreeboardVO getOnePost(FreeboardVO param) {
		return freeboardDAO.getOnePost(param);
	}

	@Override
	public List<FreeboardVO> getAllPost() {
		// TODO Auto-generated method stub
		return freeboardDAO.getAllPost();
	}	
}
