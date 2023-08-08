package com.ddu.pro.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddu.pro.command.ReviewImgVO;
import com.ddu.pro.command.ReviewVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public ArrayList<ReviewVO> getList() {
		return reviewMapper.getList();
	}

	@Override
	public ReviewVO getDetail(int rev_num) {
		return reviewMapper.getDetail(rev_num);
	}

	@Override
	public ArrayList<ReviewImgVO> getImg(String user_id) {
		return reviewMapper.getImg(user_id);
	}

}
