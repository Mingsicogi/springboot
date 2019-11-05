package com.logback.common.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthoritiesDTO {

	private int seq;
	private String userid;
	private String authority;
	
	@Builder
	public AuthoritiesDTO() {}

	@Builder
	public AuthoritiesDTO(String userid, String authority) {
		super();
		this.userid = userid;
		this.authority = authority;
	}
	
	@Builder
	public AuthoritiesDTO(int seq, String userid, String authority) {
		super();
		this.seq = seq;
		this.userid = userid;
		this.authority = authority;
	}
}