package com.ddu.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/user")
	public String test() {
		return "userservice/userservice";
	}
	
	@GetMapping("/updateUser")
	public String test2() {
		return "userservice/updateReservation";
	}
}
