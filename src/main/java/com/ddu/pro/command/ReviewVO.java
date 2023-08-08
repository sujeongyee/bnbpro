package com.ddu.pro.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewVO {
	private int rev_num;
	private LocalDateTime rev_regdate;
	private String rev_content;
	private String rev_star;
	private int room_num;
	private String user_id;
}
