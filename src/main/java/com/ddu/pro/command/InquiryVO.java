package com.ddu.pro.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InquiryVO {
	
	private String lodg_name;
	private String room_name; 
	private Integer ask_num;
	private LocalDateTime ask_regdate;
	private String ask_content;
	private char answer_check;
	private String user_id;
	private Integer room_num;
	

}
