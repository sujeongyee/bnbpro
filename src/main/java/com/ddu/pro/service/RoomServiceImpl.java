package com.ddu.pro.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.command.RoomVO;

@Service("roomService")
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomMapper roomMapper;
	
	@Override
	public ArrayList<RoomVO> getRoomList(int lodg_num) {
		return roomMapper.getRoomList(lodg_num);
	}

	@Override
	public int modifyRoom(RoomVO vo) {
		return roomMapper.modifyRoom(vo);
	}

	@Override
	public int deleteRoom(int room_num) {
		return roomMapper.deleteRoom(room_num);
	}

	@Override
	public int addRoom(RoomVO vo) {
		return roomMapper.addRoom(vo);
				
	}

	@Override
	public LodgmentVO getLodgment(int lodg_num) {
		return roomMapper.getLodgment(lodg_num);
	}

}
