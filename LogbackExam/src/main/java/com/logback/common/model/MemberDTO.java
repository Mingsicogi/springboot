package com.logback.common.model;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

	private int seq;
	private String userid;
	private String userpw;
	private String social;
	
	private boolean isAccountNonExpired = true;
	private boolean isAccountNonLock = true;
	private boolean isCredentialsIsNonExpired = true;
	private boolean enabled;
	private List<AuthoritiesDTO> authList;
	private Date rdate;
	
	@Builder
	public MemberDTO() {}

	@Builder
	public MemberDTO(int seq, String userid, String userpw, String social, boolean isAccountNonExpired,
			boolean isAccountNonLock, boolean isCredentialsIsNonExpired, boolean enabled, List<AuthoritiesDTO> authList,
			Date rdate) {
		super();
		this.seq = seq;
		this.userid = userid;
		this.userpw = userpw;
		this.social = social;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLock = isAccountNonLock;
		this.isCredentialsIsNonExpired = isCredentialsIsNonExpired;
		this.enabled = enabled;
		this.authList = authList;
		this.rdate = rdate;
	}
}
