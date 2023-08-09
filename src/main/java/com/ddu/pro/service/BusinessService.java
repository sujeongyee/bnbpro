package com.ddu.pro.service;

import javax.servlet.http.HttpSession;

import com.ddu.pro.command.BusinessVO;
import com.ddu.pro.command.LoginVO;

public interface BusinessService {
	int loginBusiness(LoginVO loginVO, HttpSession session);
	int registerBusiness(BusinessVO business);
	
	int checkDuplicate(String bn_Id);
}
