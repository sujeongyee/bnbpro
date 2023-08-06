package com.ddu.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@GetMapping("/join")
	public String join(){
		return "join";
	}
	
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	//테스트 ddu 로 들어옴
}