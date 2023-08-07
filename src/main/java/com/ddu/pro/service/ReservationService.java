package com.ddu.pro.service;

import java.util.ArrayList;

import com.ddu.pro.command.ReservationVO;
import com.ddu.pro.util.Criteria;

public interface ReservationService {
	
	ArrayList<ReservationVO> getReserv(String bn_id, Criteria cri);
	ArrayList<ReservationVO> getReservAll(String bn_id);
	ReservationVO getDetailRes(int res_num, int room_num);
	int updateReserv(ReservationVO vo);
	int deleteReserv(int res_num);
	int getTotal(String bn_id, Criteria cri);
}
