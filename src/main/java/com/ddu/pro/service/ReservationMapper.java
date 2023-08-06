package com.ddu.pro.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ddu.pro.command.ReservationVO;
@Mapper
public interface ReservationMapper {
	ArrayList<ReservationVO> getReserv();
	ReservationVO getDetailRes(@Param("res_num") int res_num, @Param("room_num") int room_num);
}
