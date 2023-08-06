package com.ddu.pro.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddu.pro.command.TestVO;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	TestMapper testMapper;

	@Override
	public ArrayList<TestVO> getTest() {
		return testMapper.getTest();
	}
	
	
	
}
