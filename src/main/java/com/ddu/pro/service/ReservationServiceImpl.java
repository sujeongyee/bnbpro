package com.ddu.pro.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddu.pro.command.ReservationVO;
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationMapper reservationMapper;
	
	@Override
	public ArrayList<ReservationVO> getReserv() {
		// TODO Auto-generated method stub
		return reservationMapper.getReserv();
	}

	@Override
	public ReservationVO getDetailRes(int res_num, int room_num) {
		// TODO Auto-generated method stub
		return reservationMapper.getDetailRes(res_num, room_num);
	}

}
