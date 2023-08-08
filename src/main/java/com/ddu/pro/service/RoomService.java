package com.ddu.pro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.command.RoomImgVO;
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
	//객실 이미지 등록
	int addRoomImg(int roomnum, List<MultipartFile> list);
	
	//제일 최근 등록된 room_num 조회
	ArrayList<RoomVO> getRoomnum();
}
