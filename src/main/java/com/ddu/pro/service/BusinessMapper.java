package com.ddu.pro.service;

import org.apache.ibatis.annotations.Mapper;

import com.ddu.pro.command.BusinessVO;
@Mapper
public interface BusinessMapper {
	void insertBusiness(BusinessVO business);
    BusinessVO getBusinessById(String bn_Id);
    int checkDuplicateBusinessId(String string);
}
