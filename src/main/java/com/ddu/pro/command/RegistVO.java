package com.ddu.pro.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistVO {
	
	private String ask_content;
	private String answer_check;
	private String user_id;
	private Integer room_num;

}
