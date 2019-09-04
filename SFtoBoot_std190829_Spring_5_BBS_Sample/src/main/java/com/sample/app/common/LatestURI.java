package com.sample.app.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**가장 마지막에 접근했던 URI로 redirect 하기 위한 클래스
 * path정보를 로그아웃 컨트롤러에 전달
 * @author mihj
 *
 */
@Getter
@Setter
@ToString
public class LatestURI {
	
	private String uri;
	private String contextPath;
	private String servletPath;
	private String uniCode;

	public String getUri() {
		this.uri = this.contextPath + this.servletPath;
		this.uri += ( contextPath.length() < 1 )?"":"?"+contextPath;
		
		return this.uri;
	}
	
	@Builder
	public LatestURI() { }

	@Builder
	public LatestURI(String contextPath, String servletPath, String uniCode) {
		super();
		this.contextPath = contextPath;
		this.servletPath = servletPath;
		this.uniCode = uniCode;
	}
	
}
