package com.ddu.pro.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.command.TestVO;
import com.ddu.pro.service.LodgmentService;
import com.ddu.pro.service.TestService;

@Controller
public class MainController {
	
	
	@Autowired
	@Qualifier("lodgmentService")
	private LodgmentService lodgmentSerivce;
	
	@Value("${project.upload.path}")
	private String uploadPath;
	
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
	
	// 모든 숙소 정보 리스트 가지고 메인으로
	@GetMapping("/main")
	public String main(Model model) {
		
		List<LodgmentVO> list= lodgmentSerivce.getLodgList("admin");
		model.addAttribute("list", list);
		return "main";
	}
	
	// 메인에서 이미지 출력해주는 메서드
	@GetMapping("/display")
	public @ResponseBody ResponseEntity<byte[]> display(@RequestParam("filename") String filename,
										  @RequestParam("filepath") String filepath,
										  @RequestParam("uuid") String uuid){

		String path = uploadPath + "/" + filepath + "/" + uuid+ "_" + filename;
		File file = new File(path);
		byte[] arr = null;
		try { 
			arr = FileCopyUtils.copyToByteArray(file); // 파일경로기반으로 데이터를 구함
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<>(arr,HttpStatus.OK);
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