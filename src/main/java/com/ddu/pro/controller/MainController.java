package com.ddu.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddu.pro.command.TestVO;
import com.ddu.pro.service.TestService;

@Controller
public class MainController {
	
	@Autowired
	TestService testService;
	
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
	@GetMapping("/calendar")
	public String calendar() {
		return "calendar";
	}
	@GetMapping("/test")
	public @ResponseBody ResponseEntity<List<com.ddu.pro.command.TestVO>> test(){
		System.out.println("d");
		return new ResponseEntity<List<TestVO>>(testService.getTest(), HttpStatus.OK);
	}
	//테스트 ddu 로 들어옴
}