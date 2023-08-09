package com.ddu.pro.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ddu.pro.command.ReviewImgVO;
import com.ddu.pro.command.ReviewVO;

@Mapper
public interface ReviewMapper {
	public ArrayList<ReviewVO> getList();
	public ReviewVO getDetail(int rev_num);
	public ArrayList<ReviewImgVO> getImg(String user_id);

}
