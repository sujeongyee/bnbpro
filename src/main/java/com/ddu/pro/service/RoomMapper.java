package com.ddu.pro.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.command.RoomImgVO;
import com.ddu.pro.command.RoomVO;

@Mapper
public interface RoomMapper {
	// 숙소에 따른 객실 조회
	ArrayList<RoomVO> getRoomList(int lodg_num);

	// 객실 수정
	int modifyRoom(RoomVO vo);

	// 객실 삭제
	int deleteRoom(int room_num);

	// 객실 등록
	int addRoom(RoomVO vo);

	// 사진 조회 할 때만
	LodgmentVO getLodgment(int lodg_num);
	
	// 이미지 등록
	int registRoomImg(RoomImgVO vo);
	
	// 최근 번호 조회
	ArrayList<RoomVO> getRoomnum();
	
	// 이미지 조회
	ArrayList<RoomImgVO> getimgList(int room_num);
	
	// 객실 하나 조회
	RoomVO getRoom(String room_num);
	
	//이미지 수정
	int modifyRoomImg(@Param("vo") RoomImgVO vo, @Param("ro_img_num") int ro_img_num);
}
