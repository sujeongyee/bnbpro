package com.ddu.pro.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomImgVO {
	/*
	 * ro_img_num int primary key auto_increment,
    ro_img_filename varchar(20),
    ro_img_filepath varchar(40),
    ro_img_uuid varchar(50),
    ro_img_regdate timestamp DEFAULT NOW(),
    room_num int
	 */
	
	private Integer ro_img_num;
	private String ro_img_filename;
	private String ro_img_filepath;
	private String ro_img_uuid;
	private String ro_img_regdate;
	private Integer room_num;
}
