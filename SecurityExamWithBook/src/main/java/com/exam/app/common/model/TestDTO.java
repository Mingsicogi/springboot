package com.exam.app.common.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO implements Serializable {

	private String userid;
	private String userpw;
	private boolean enabled;
	private List<AuthDTO> authList;
		
}