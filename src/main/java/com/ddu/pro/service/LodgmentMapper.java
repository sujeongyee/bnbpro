package com.ddu.pro.service;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ddu.pro.command.LodgmentVO;

@Mapper
public interface LodgmentMapper {
	
	public int lodgmentRegist(LodgmentVO vo);
	public List<LodgmentVO> getLodgList(String bn_id);
	public LodgmentVO getLodgment(String lodg_num);
	public void deleteLodg(String lodg_num);
}
