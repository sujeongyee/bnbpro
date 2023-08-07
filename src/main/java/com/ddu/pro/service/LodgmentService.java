package com.ddu.pro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ddu.pro.command.LodgmentVO;



public interface LodgmentService {
	
	public int lodgmentRegist(LodgmentVO vo,List<MultipartFile> list); // 숙소 등록
	public List<LodgmentVO> getLodgList(String bn_id); //메인에서 숙소 정보가져오기
	public LodgmentVO getLodgment(String lodg_num); //수정 누른 숙소 정보
	public void deleteLodg(String lodg_num); //삭제 누른 숙소

}
