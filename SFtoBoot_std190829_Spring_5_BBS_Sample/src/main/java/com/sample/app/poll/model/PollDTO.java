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
public class PollDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int pollid;	//sequence
	private String id;	//투표 게시자
	private String question;	//투표 주제
	private Date sdate;	//시작일
	private Date edate;	//종료일
	
	private int itemcount;	//선택지(보기)의 개수
	private int polltotal;	//이 질문에 투표한 사람의 수
	
	private Date regdate;	//등록일
	
	private boolean vote;	//투표를 했는지 안했는지 여부를 걸러주는 변수
	
	@Builder
	public PollDTO() { }
	
	/** 선택지를 보여주기 위한 생성자
	 * @param id
	 * @param question
	 * @param itemcount
	 */
	@Builder
	public PollDTO(String id, String question, int itemcount) {
		super();
		this.id = id;
		this.question = question;
		this.itemcount = itemcount;
	}

	/**투표를 등록할 때 필요한 생성자
	 * @param id
	 * @param question
	 * @param sdate
	 * @param edate
	 * @param itemcount
	 * @param polltotal
	 */
	@Builder
	public PollDTO(String id, String question, Date sdate, Date edate, int itemcount, int polltotal) {
		super();
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
	}
	
	/**All Args Constructor
	 * @param pollid
	 * @param id
	 * @param question
	 * @param sdate
	 * @param edate
	 * @param itemcount
	 * @param polltotal
	 * @param regdate
	 */
	@Builder
	public PollDTO(int pollid, String id, String question, Date sdate, Date edate, int itemcount, int polltotal,
			Date regdate, boolean vote) {
		super();
		this.pollid = pollid;
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
		this.regdate = regdate;
		this.vote = vote;
	}
}
