package com.ddu.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddu.pro.command.InquiryVO;
import com.ddu.pro.command.LodgmentVO;

@Service("csSerivce")
public class CSServiceImpl implements CSSerivce{
	
	@Autowired
	private CSMapper csMapper;

	@Override
	public List<LodgmentVO> getLodgName(String bn_id) {
		
		return csMapper.getLodgName(bn_id);
	}

	@Override
	public List<InquiryVO> getLodgIngury(String lodg) {
	
		return csMapper.getLodgIngury(lodg);
	}

	@Override
	public List<InquiryVO> getAll() {
		
		return csMapper.getAll();
	}

	@Override
	public List<InquiryVO> getAnswer(String answer_num) {

		return csMapper.getAnswer(answer_num);
	}

	@Override
	public void registAnswer(String answer, int num) {
		
		csMapper.registAnswer(answer, num);
	}

	@Override
	public void check(int num) {
		csMapper.check(num);
		
	}
	
	

}
