package com.sample.app.poll.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.app.poll.dao.PollDAO;
import com.sample.app.poll.model.PollDTO;
import com.sample.app.poll.model.VoterDTO;

@Repository
public class PollDAOImpl implements PollDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PollDTO> getAllPollList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int isVote(VoterDTO voter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
