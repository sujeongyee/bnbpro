package com.ddu.pro.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ddu.pro.command.InquiryVO;
import com.ddu.pro.command.LodgmentVO;

@Mapper
public interface CSMapper {
	public List<LodgmentVO> getLodgName(String bn_id);
	public List<InquiryVO> getLodgIngury(String lodg);
	public List<InquiryVO> getAll();
}
