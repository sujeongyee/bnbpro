package com.ddu.pro.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomVO {
	/*
	 * room_num int primary key auto_increment,
    room_name varchar(20),
    room_price varchar(40),
    room_detail varchar(1000),
    room_users int,
    lodg_num int
	 */
	
	private Integer room_num;
	private String room_name;
	private Integer room_price;
	private String room_detail;
	private Integer room_users;
	private Integer lodg_num;
	
}
