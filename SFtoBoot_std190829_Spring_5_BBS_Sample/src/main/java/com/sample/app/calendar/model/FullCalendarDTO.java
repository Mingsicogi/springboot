package com.sample.app.calendar.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FullCalendarDTO {

	private String title;
	private String start;
	private String end;
	private String allDay;
	
	@Builder
	public FullCalendarDTO() { }

	@Builder
	public FullCalendarDTO(String title, String start, String end, String allDay) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		this.allDay = allDay;
	}
}
