package com.ddu.pro.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationVO {
	
	
	private Integer res_num;
	private String res_name;
	private String res_phone;
	private String res_startdate;
	private String res_enddate;
	private Integer res_price;
	private Integer res_users;
	private String user_id;
	private Integer room_num;
}
