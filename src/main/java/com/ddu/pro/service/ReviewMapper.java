package com.ddu.pro.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ddu.pro.command.ReviewImgVO;
import com.ddu.pro.command.ReviewVO;
import com.ddu.pro.util.Criteria3;

@Mapper
public interface ReviewMapper {
	public ArrayList<ReviewVO> getList(Criteria3 cri);//조회
	public int getTotal(Criteria3 cri);
	
	public ReviewVO getDetail(int rev_num);//상세
	public ArrayList<ReviewImgVO> getImg(int rev_num);//이미지 가져오기

}
