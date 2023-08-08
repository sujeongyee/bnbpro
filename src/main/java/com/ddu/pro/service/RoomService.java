package com.ddu.pro.service;

import java.util.ArrayList;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.command.RoomVO;

public interface RoomService {	
	
	//숙소에 따른 객실 조회
	ArrayList<RoomVO> getRoomList(int lodg_num);
	//객실 수정
	int modifyRoom(RoomVO vo);
	//객실 삭제
	int deleteRoom(int room_num);
	//객실 등록
	int addRoom(RoomVO vo);
	//사진 띄우려고 lodg 하나 조회
	LodgmentVO getLodgment(int lodg_num);
}