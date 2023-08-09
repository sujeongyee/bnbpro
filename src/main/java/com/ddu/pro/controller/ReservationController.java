package com.ddu.pro.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddu.pro.command.CalendarVO;
import com.ddu.pro.command.ReservationVO;
import com.ddu.pro.service.ReservationService;
import com.ddu.pro.util.Criteria;
import com.ddu.pro.util.PageVO;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	
	@Autowired
	ReservationService reservationService;
	
	// 예약 정보 전체 조회
	@GetMapping("/allList")
	public String getAllList(Model model, Criteria cri) {
		System.out.println("##################################");
		System.out.println(cri.toString());
		System.out.println("##################################");
		String bn_id = "admin";
		PageVO page = new PageVO(cri, reservationService.getTotal(bn_id, cri));
		model.addAttribute("list",reservationService.getReserv(bn_id, cri));
		model.addAttribute("page",page);
		return "reservation/reservList";
	}
	
	
	//수정하기 페이지 이동
	@GetMapping("/updateForm")
	public String getDetail(@RequestParam("num") int res_num, @RequestParam("room") int room_num,Model model) {
		
		model.addAttribute("vo",reservationService.getDetailRes(res_num, room_num));
		
		return "reservation/updateReservation";
	}
	
	//달력에 띄워줄 때 얻어올 JSON
	@GetMapping("/reservList")
	public @ResponseBody ResponseEntity<ArrayList<CalendarVO>> getCalendar() {
		ArrayList<CalendarVO> calList = new ArrayList<>();
		String bn_id = "admin";
		for(ReservationVO v : reservationService.getReservAll(bn_id)) {
			String url = "/reservation/updateForm/?num="+v.getRes_num()+"&room="+v.getRoom_num();
			CalendarVO vo = new CalendarVO(v.getRes_num(),v.getRoom_name(), v.getRes_startdate(), v.getRes_enddate(),url);
			System.out.println(vo.getEnd());
			calList.add(vo);
		}
		
		return new ResponseEntity<ArrayList<CalendarVO>>(calList, HttpStatus.OK);
	}
	
	//예약 정보 삭제
	@GetMapping("/reservDelete")
	public String reservDelete(@RequestParam("num") int res_num) {
		
		return "redirect:/reservation/allList";
	}
	
	//예약 정보 변경
	@PostMapping("modifyReserv")
	public String modifyReserv(ReservationVO vo) {
		System.out.println(vo.toString());
		return "redirect:/reservation/allList";
	}
}
