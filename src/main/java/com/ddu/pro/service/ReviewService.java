package com.ddu.pro.service;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddu.pro.command.ReviewImgVO;
import com.ddu.pro.command.ReviewVO;
import com.ddu.pro.util.Criteria3;

public interface ReviewService {
	public ArrayList<ReviewVO> getList(Criteria3 cri);
	public int getTotal(Criteria3 cri);
	
	public ReviewVO getDetail(int rev_num);
	public ArrayList<ReviewImgVO> getImg(int rev_num);
}
