package com.mhjFreeBoardv12.app.freeboard.service;

import java.util.List;

import com.mhjFreeBoardv12.app.freeboard.vo.FreeboardVO;

public interface FreeboardService {
	public FreeboardVO getOnePost(FreeboardVO param);
	
	public List<FreeboardVO> getAllPost();
}
