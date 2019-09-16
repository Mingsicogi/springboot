package com.cbt.app.common.util;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LatestURI implements Serializable{
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
