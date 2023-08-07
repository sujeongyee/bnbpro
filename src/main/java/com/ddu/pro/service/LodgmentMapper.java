package com.ddu.pro.service;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.util.Criteria;
import com.ddu.pro.util.Criteria2;

@Mapper
public interface LodgmentMapper {
	
	public int lodgmentRegist(LodgmentVO vo);
	public List<LodgmentVO> getLodgList(@Param("bn_id") String bn_id, @Param("cri") Criteria2 cri);
	public LodgmentVO getLodgment(String lodg_num);
	public void deleteLodg(String lodg_num);
	public void updateLodg(LodgmentVO vo);
	int getTotal(@Param("bn_id") String bn_id, @Param("cri") Criteria2 cri);
}
