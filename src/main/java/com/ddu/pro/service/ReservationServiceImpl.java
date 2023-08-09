package com.ddu.pro.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddu.pro.command.ReservationVO;
import com.ddu.pro.util.Criteria;
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationMapper reservationMapper;
	
	@Override
	public ArrayList<ReservationVO> getReserv(String bn_id, Criteria cri) {
		return reservationMapper.getReserv(bn_id, cri);
	}

	@Override
	public ReservationVO getDetailRes(int res_num, int room_num) {
		return reservationMapper.getDetailRes(res_num, room_num);
	}

	@Override
	public int updateReserv(ReservationVO vo) {
		return reservationMapper.updateReserv(vo);
	}

	@Override
	public int deleteReserv(int res_num) {
		return reservationMapper.deleteReserv(res_num);
	}

	@Override
	public int getTotal(String bn_id, Criteria cri) {
		return reservationMapper.getTotal(bn_id, cri);
	}

	@Override
	public ArrayList<ReservationVO> getReservAll(String bn_id) {
		return reservationMapper.getReservAll(bn_id);
	}

	@Override
	public ArrayList<ReservationVO> getRoomnum(int lodg_num) {
		return reservationMapper.getRoomnum(lodg_num);
	}

}
