package com.ddu.pro.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalendarVO {
	private Integer id;
	private Integer title;
	private String start;
	private String end;
	private String url;
}
