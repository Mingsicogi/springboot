package com.cbt.app.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamTestDTO implements Serializable{
	private String title;
	private String subject;
	private String limit_time;	
}
