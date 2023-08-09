package com.ddu.pro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.command.RegistVO;
import com.ddu.pro.service.CSMapper;
import com.ddu.pro.service.LodgmentMapper;

@SpringBootTest
public class InsertData {
	
	@Autowired
	private CSMapper csMapper;
	
	@Autowired
	private LodgmentMapper mapper;
	
	/*
	안녕하세요! 여기 숙소 예약 가능한지 여쭤봅니다.
	숙소에 반려동물 동반 가능한가요?
	가족 4인이 묵을 예정인데, 가격과 예약 가능 여부를 알려주세요.
	숙소 내 풀장 이용 가능한지 궁금합니다.
	바다가 보이는 뷰가 있는 숙소인가요?
	주차장이 따로 마련되어 있는지 알고 싶습니다.
	결혼 기념일에 특별 서비스나 이벤트가 있는지 궁금합니다.
	3박 4일로 예약하려고 하는데 할인 혜택이 있는지 알려주세요.
	무료 와이파이 서비스가 있는지 확인 부탁드립니다.
	숙소 내 레스토랑 메뉴와 가격을 알고 싶습니다.
	체크인 및 체크아웃 시간을 알려주세요.
	주변 관광 명소나 추천 장소가 있다면 알려주세요.
	아기 의자나 유아용 침대 대여 가능한가요?
	숙소 내 셀프 빨래 서비스가 있는지 궁금합니다.
	주변에 슈퍼마켓이나 편의점이 있는지 알려주세요.
	숙소 내 룸 서비스 메뉴와 시간을 확인하고 싶습니다.
	추가 요금 없이 인원 추가 가능한지 여쭤봅니다.
	단체로 묵을 예정이며, 단체 할인이 있는지 알려주세요.
	숙소 내 휴식 공간이나 라운지가 있는지 알고 싶습니다.
	체크아웃 시 미리 수하물 보관 서비스를 이용할 수 있을까요?
	숙소 주변에 자전거 대여 서비스가 있는지 궁금합니다.
	무료 주차 가능 여부와 주차장의 크기를 알려주세요.
	숙소 내 스파나 웰니스 시설을 이용할 수 있는지 여쭤봅니다.
	특정 날짜에 예약 가능한지 확인하고 싶습니다.
	숙소 내 미니바와 간식 서비스에 대한 정보를 알려주세요.
	예약 취소 정책이 어떻게 되는지 알려주세요.
	숙소 내 피트니스 센터나 체육시설을 이용할 수 있는지 궁금합니다.
	현지 관세 및 세금 등 추가 비용이 있는지 알고 싶습니다.
	숙소 내 업무 센터나 회의실을 이용할 수 있는지 여쭤봅니다.
	숙소 예약 시 필요한 서류나 절차에 대한 안내를 부탁드립니다.
	*/
	@Test
	public void insertData01() {
			
			
			for(int i = 21; i <=120 ; i++) {
				LodgmentVO vo = LodgmentVO.builder().
						        lodg_type("펜션").
						        lodg_name("안녕? 제주!").
						        lodg_rg("제주특별자치도 서귀포시 가가로 14").
						        lodg_addr("105 안녕 제주? 펜션").
						        lodg_img_filename("KakaoTalk_20230809_113855467_01.webp").
						        lodg_img_filepath("20230809").
						        lodg_img_uuid("08001b26-9a74-49fc-a1c0-05ac8c6392be").
						        lodg_ph("010-2222-3333").
						        lodg_content("해변 휴양지 숙소. 넓은 객실과 해변 접근성. 지역 특산물 요리. 주변 관광명소.").
						        bn_id("qwert12345").build();
						        
					
			mapper.lodgmentRegist(vo);
//				mapper.deleteLodg(i+"");
			}
		
			
		
		
	}

}
