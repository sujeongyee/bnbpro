package com.ddu.pro.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddu.pro.command.BusinessVO;
import com.ddu.pro.command.LoginVO;

@Service("businessService")
@Transactional(readOnly = true)
public class BusinessServiceImpl implements BusinessService{
	
	@Autowired
    private BusinessMapper businessMapper;
	
	@Override
	@Transactional
    public int registerBusiness(BusinessVO business) {
        int duplicateCount = businessMapper.checkDuplicateBusinessId(business.getBn_id());
        if (duplicateCount > 0) {
//            throw new RuntimeException("중복된 사용자 ID입니다."); // 중복된 경우 예외 처리
        	return 1;
        }
        
        businessMapper.insertBusiness(business);
         
        return 0;  
    }


    @Override
    @Transactional
    public int loginBusiness(LoginVO loginVO, HttpSession session) {
        BusinessVO businessVO = businessMapper.getBusinessById(loginVO.getBn_id());
        
        if (businessVO == null) {
            return 1; // 사용자 ID가 없는 경우
        }

        if (!businessVO.getBn_pw().equals(loginVO.getBn_pw())) {
            return 2; // 비밀번호 불일치
        }

        session.setAttribute("userid", businessVO.getBn_id());
        return 0; // 로그인 성공
    }


	@Override
	public int checkDuplicate(String bn_Id) {
		
	   int duplicateCount = businessMapper.checkDuplicateBusinessId(bn_Id);
	   
        if (duplicateCount > 0) {
        	return 1;
        }

		return 0;
	}
}
