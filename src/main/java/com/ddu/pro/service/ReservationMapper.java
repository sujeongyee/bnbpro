package com.ddu.pro.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ddu.pro.command.ReservationVO;
import com.ddu.pro.util.Criteria;
@Mapper
public interface ReservationMapper {
	ArrayList<ReservationVO> getReserv(@Param("bn_id") String bn_id, @Param("cri") Criteria cri);
	ArrayList<ReservationVO> getReservAll(String bn_id);
	ReservationVO getDetailRes(@Param("res_num") int res_num, @Param("room_num") int room_num);
	int updateReserv(ReservationVO vo);
	int deleteReserv(int res_num);
	int getTotal(@Param("bn_id") String bn_id, @Param("cri") Criteria cri);
	ArrayList<ReservationVO> getRoomnum(int lodg_num);
}
