package com.ddu.pro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.service.LodgmentMapper;

@SpringBootTest
public class InsertData {
	
	@Autowired
	private LodgmentMapper lodgmentMapper;
	
	@Test
	public void insertData01() {
		
		for(int i =1; i <=66 ;i++) {
			LodgmentVO vo = LodgmentVO.builder()
							.lodg_type("펜션")
							.lodg_name("하루 감성한옥" + i)
							.lodg_rg("제주특별자치도 제주시 구좌읍")
							.lodg_addr("105-"+i)
							.lodg_img_filename("이미지.jpg")
							.lodg_img_filepath("20230806")
							.lodg_img_uuid("4f2896c9-feb9-448b-ad5a-0568eb933889")
							.lodg_ph("010-1234-12"+i)
							.lodg_content("세화해변 도보 " + i + "분 거리 오션뷰 펜션")
							.bn_id("admin")
					.build();
			lodgmentMapper.lodgmentRegist(vo);
		}
		
	}

}
