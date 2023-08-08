package com.ddu.pro.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ddu.pro.command.RoomImgVO;
import com.ddu.pro.command.RoomVO;
import com.ddu.pro.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Value("${project.upload.path}")
	private String uploadPath;
	
	@Autowired
	private RoomService roomService;

	

	@GetMapping("/List")
	public String roomList(@RequestParam("lodg_num") int num, Model model) {
		model.addAttribute("list", roomService.getRoomList(num));
		model.addAttribute("lodg", roomService.getLodgment(num));
		return "room/roomList";
	}
	
	
	//객실 등록 페이지 이동
	@GetMapping("/registRoom")
	public String regRoom(@RequestParam("lodg_num") int num, Model model) {
		//사진 정보 부를거라 여기서 숙소정보 보낼거임
		model.addAttribute("lodg", roomService.getLodgment(num));
		return "room/regRoom";
	}

	//객실 등록
	@PostMapping("/resistForm")
	public String resistForm(RoomVO vo, @RequestParam("file") List<MultipartFile> list) {
		int result = roomService.addRoom(vo);
		
		int roomnum =  roomService.getRoomnum().get(0).getRoom_num();
		
		
		roomService.addRoomImg(roomnum,list);
		
		if(result==1) {
			return "redirect:/main";	
		}else {
			return "redirect:/room/registRoom?lodg_num="+vo.getLodg_num();
		}
		
	}

	// 이미지 띄워주기
	@GetMapping("/display")
	public @ResponseBody byte[] display(@RequestParam("filename") String filename,
			@RequestParam("filepath") String filepath, @RequestParam("uuid") String uuid) {

		byte[] data = null;
		// 읽어올 경로
		String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
		try {
			data = FileCopyUtils.copyToByteArray(new File(path));/// 이미지 경로를 바이트배열로 구함
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
	
	
	//객실별 이미지 JSON으로 보내기
	@GetMapping("/getimgList")
	public @ResponseBody ResponseEntity<ArrayList<RoomImgVO>> getimgList(@RequestParam("room_num") int num){
		
		return new ResponseEntity<ArrayList<RoomImgVO>>(roomService.getimgList(num), HttpStatus.OK);
	}
}
