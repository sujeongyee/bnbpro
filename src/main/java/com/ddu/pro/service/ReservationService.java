package com.ddu.pro.service;

import java.util.ArrayList;

import com.ddu.pro.command.ReservationVO;

public interface ReservationService {
	
	ArrayList<ReservationVO> getReserv();
	ReservationVO getDetailRes(int res_num, int room_num);
}
