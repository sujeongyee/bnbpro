package com.ddu.pro.service;

import java.util.List;

import com.ddu.pro.command.InquiryVO;
import com.ddu.pro.command.LodgmentVO;

public interface CSSerivce {
	
	public List<LodgmentVO> getLodgName(String bn_id);
	public List<InquiryVO> getLodgIngury(String lodg);
	public List<InquiryVO> getAll();
}
