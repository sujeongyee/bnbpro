package com.ddu.pro.command;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LodgmentVO {
	
	private String lodg_num;
	private String lodg_type;
	private String lodg_name;
	private String lodg_rg;
	private String lodg_addr;
	private String lodg_img_filename;
	private String lodg_img_filepath;
	private String lodg_img_uuid;
	@Pattern(message="비밀번호는 숫자(2,3개)-숫자(3,4개)-숫자4개 형식입니다", regexp="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}")
	private String lodg_ph;
	private String lodg_content;
	private String bn_id;
	

}
