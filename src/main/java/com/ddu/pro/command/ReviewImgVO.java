package com.ddu.pro.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewImgVO {

	private int rev_img_num;
	private String rev_img_filename;
	private String rev_img_filepath;
	private String rev_img_uuid;
	private String user_id;
	private int rev_num;
}
