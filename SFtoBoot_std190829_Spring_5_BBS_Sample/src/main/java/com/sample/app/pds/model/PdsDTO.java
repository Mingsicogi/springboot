package com.sample.app.pds.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PdsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int rnum;
	private int seq;
	private String id;
	private String title;
	private String content;

	private String filename;// 업로드된 파일 이름(저장하기위해 바뀐) 사실 오리지널 이름이 있어야함
	private String origin_filename;
	private int readcount;
	private int downcount;// 다운 수
	private String regdate;// 등록일

	//No Args Constructor
	@Builder
	public PdsDTO() {}
	
	// 유저 입력값만 받는 생성자
	@Builder
	public PdsDTO(String id, String title, String content, String filename, String origin_filename) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.origin_filename = origin_filename;
	}

	// 수정용 생성자
	@Builder
	public PdsDTO(int seq, String id, String title, String content, String filename, String origin_filename) {
			this.seq = seq;
			this.id = id;
			this.title = title;
			this.content = content;
			this.filename = filename;
			this.origin_filename = origin_filename;
	}

	//All arguments constructor
	@Builder
	public PdsDTO(int seq, String id, String title, String content, String filename, String origin_filename,
			int readcount, int downcount, String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.origin_filename = origin_filename;
		this.readcount = readcount;
		this.downcount = downcount;
		this.regdate = regdate;
	}
	
	//All arguments constructor + rnum
		@Builder
		public PdsDTO(int rnum, int seq, String id, String title, String content, String filename, String origin_filename,
				int readcount, int downcount, String regdate) {
			super();
			this.rnum = rnum;
			this.seq = seq;
			this.id = id;
			this.title = title;
			this.content = content;
			this.filename = filename;
			this.origin_filename = origin_filename;
			this.readcount = readcount;
			this.downcount = downcount;
			this.regdate = regdate;
		}
}
