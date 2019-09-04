package com.sample.app.poll.dao;

import java.util.List;

import com.sample.app.poll.model.PollDTO;
import com.sample.app.poll.model.VoterDTO;

public interface PollDAO {

	/** POLL DB의 모든 주제를 가져오는 메소드
	 * @return
	 */
	public List<PollDTO> getAllPollList();
	
	/** voter가 가진 user id가 voter가 가진 pollid에 참여했는지 여부를 리턴하는 메소드
	 * @param voter
	 * @return
	 */
	public int isVote(VoterDTO voter);
}
