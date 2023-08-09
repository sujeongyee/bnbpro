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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotal(String bn_id, Criteria cri) {
		// TODO Auto-generated method stub
		return reservationMapper.getTotal(bn_id, cri);
	}

	@Override
	public ArrayList<ReservationVO> getReservAll(String bn_id) {
		// TODO Auto-generated method stub
		return reservationMapper.getReservAll(bn_id);
	}

	@Override
	public ArrayList<ReservationVO> getRoomnum(int lodg_num) {
		return reservationMapper.getRoomnum(lodg_num);
	}

}
