package com.ddu.pro.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ddu.pro.command.CalendarVO;
import com.ddu.pro.command.ReservationVO;
import com.ddu.pro.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/updateForm/{num}/{room}")
	public String getDetail(@PathVariable("num") int res_num, @PathVariable("room") int room_num,Model model) {
		
		model.addAttribute("vo",reservationService.getDetailRes(res_num, room_num));
		
		return "userservice/updateReservation";
	}
	
	@GetMapping("/reservList")
	public @ResponseBody ResponseEntity<ArrayList<CalendarVO>> getCalendar() {
		ArrayList<CalendarVO> calList = new ArrayList<>();
		for(ReservationVO v : reservationService.getReserv()) {
			String url = "/reservation/updateForm/"+v.getRes_num()+"/"+v.getRoom_num();
			CalendarVO vo = new CalendarVO(v.getRes_num(),v.getRoom_num()+"호", v.getRes_startdate(), v.getRes_enddate(),url);
			System.out.println(vo.getEnd());
			calList.add(vo);
		}
		
		return new ResponseEntity<ArrayList<CalendarVO>>(calList, HttpStatus.OK);
	}
	
	
	
}
