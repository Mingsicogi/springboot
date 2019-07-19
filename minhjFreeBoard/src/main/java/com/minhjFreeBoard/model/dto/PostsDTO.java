package com.minhjFreeBoard.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsDTO {
	private int seq;
	private String id;
	private String title;
	private String content;
	private Date post_date;
	private int del;
	private int readcount;	
}
