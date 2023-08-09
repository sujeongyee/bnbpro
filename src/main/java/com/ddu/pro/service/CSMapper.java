package com.ddu.pro.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ddu.pro.command.InquiryVO;
import com.ddu.pro.command.LodgmentVO;

@Mapper
public interface CSMapper {
	public List<LodgmentVO> getLodgName(String bn_id);
	public List<InquiryVO> getLodgIngury(String lodg);
	public List<InquiryVO> getAll();
	public List<InquiryVO> getAnswer(String answer_num);
	public void registAnswer(@Param("answer") String answer , @Param("num") int num);
	public void check (int num);
}
