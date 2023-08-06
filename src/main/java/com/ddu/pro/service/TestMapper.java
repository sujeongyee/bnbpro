package com.ddu.pro.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ddu.pro.command.TestVO;

@Mapper
public interface TestMapper {
	ArrayList<TestVO> getTest();
}
