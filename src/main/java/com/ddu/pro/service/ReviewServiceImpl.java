package com.ddu.pro.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddu.pro.command.ReviewImgVO;
import com.ddu.pro.command.ReviewVO;
import com.ddu.pro.util.Criteria3;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public ArrayList<ReviewVO> getList(Criteria3 cri) {
		return reviewMapper.getList(cri);
	}

	@Override
	public int getTotal(Criteria3 cri) {
		return reviewMapper.getTotal(cri);
	}

	@Override
	public ReviewVO getDetail(int rev_num) {
		return reviewMapper.getDetail(rev_num);
	}

	@Override
	public ArrayList<ReviewImgVO> getImg(int rev_num) {
		return reviewMapper.getImg(rev_num);
	}


}
