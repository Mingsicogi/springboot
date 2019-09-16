package com.cbt.app.exams.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamSubListDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<ExamSubDTO> examSubList;
}
