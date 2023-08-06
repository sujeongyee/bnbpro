package com.ddu.pro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ddu.pro.command.LodgmentVO;



public interface LodgmentService {
	
	public int lodgmentRegist(LodgmentVO vo,List<MultipartFile> list);
	public List<LodgmentVO> getLodgList(String bn_id);

}
