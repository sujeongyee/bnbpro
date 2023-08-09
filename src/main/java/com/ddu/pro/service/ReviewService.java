package com.ddu.pro.service;

import java.util.ArrayList;

import com.ddu.pro.command.ReviewImgVO;
import com.ddu.pro.command.ReviewVO;

public interface ReviewService {
	public ArrayList<ReviewVO> getList();
	public ReviewVO getDetail(int rev_num);
	public ArrayList<ReviewImgVO> getImg(String user_id);
}
