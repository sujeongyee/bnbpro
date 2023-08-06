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
		return reservationMapper.getReserv();
	}

	@Override
	public ReservationVO getDetailRes(int res_num, int room_num) {
		return reservationMapper.getDetailRes(res_num, room_num);
	}

	@Override
	public int updateReserv(ReservationVO vo) {
		return reservationMapper.updateReserv(vo);
	}

}
