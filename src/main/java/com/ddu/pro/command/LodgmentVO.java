package com.ddu.pro.command;

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
	private String lodg_ph;
	private String lodg_content;
	private String bn_id;
	

}
