package com.sample.app.poll.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VoterDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int voterid;	//현재 DTO의 seq
	private int pollid;		//주제 id
	private int pollsubid;	//선택지 id
	private String id;		//투표자 id
	private Date regdate;	//투표시점
	
	/** No Args Constructor
	 * 
	 */
	@Builder
	public VoterDTO() { }

	/** id에 해당하는 유저가 pollid에 투표를 했는지 여부를 알기위한 데이터를 갖는 생성자
	 * @param pollid
	 * @param pollsubid
	 * @param id
	 */
	@Builder
	public VoterDTO(int pollid, int pollsubid, String id) {
		super();
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
	}
	
	/** All Args Constructor
	 * @param voterid
	 * @param pollid
	 * @param pollsubid
	 * @param id
	 * @param regdate
	 */
	@Builder
	public VoterDTO(int voterid, int pollid, int pollsubid, String id, Date regdate) {
		super();
		this.voterid = voterid;
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
		this.regdate = regdate;
	}

 
}
