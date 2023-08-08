package com.ddu.pro.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ddu.pro.command.RoomVO;
import com.ddu.pro.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Value("${project.upload.path}")
	private String uploadPath;

	@Autowired
	private RoomService roomService;

	// 폴더 생성 함수
	public String makeFolder() {
		String path = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		File file = new File(uploadPath + "/" + path);
		if (file.exists() == false) { // 존재하면 true, 존재하지 않으면 false
			file.mkdirs();
		}
		return path;
	}

	@GetMapping("/List")
	public String roomList(@RequestParam("lodg_num") int num, Model model) {
		model.addAttribute("list", roomService.getRoomList(num));

		return "room/roomList";
	}
	
	
	//숙소 등록 페이지 이동
	@GetMapping("/registRoom")
	public String regRoom(@RequestParam("lodg_num") int num, Model model) {
		//사진 정보 부를거라 여기서 숙소정보 보낼거임
		model.addAttribute("lodg", roomService.getLodgment(num));
		return "room/regRoom";
	}

	//숙소 등록
	@PostMapping("/resistForm")
	public String resistForm(RoomVO vo) {
		int result = roomService.addRoom(vo);
		if(result==1) {
			return "redirect:/main";	
		}else {
			return "redirect:/room/registRoom?lodg_num="+vo.getLodg_num();
		}
		
		//return "redirect:/main";
	}
	
	
	// 복수 태그를 사용한 다중파일 업로드 - List(MultipartFile)
	@PostMapping("/upload_ok2")
	public String upload_ok2(@RequestParam("file") List<MultipartFile> list) {
		// 빈 file객체는 제외, 파일 받아온것만 리스트로 새로 생성
		list = list.stream().filter(f -> f.isEmpty() == false).collect(Collectors.toList());

		for (MultipartFile file : list) {

			// System.out.println(file.isEmpty());
			// 파일이름을 받습니다.
			String originName = file.getOriginalFilename();
			// 브라우저 별로 파일의 경로가 다를수 있기 때문에 \\ 기준으로 파일명만 잘라서 다시 저장
			String filename = originName.substring(originName.lastIndexOf("\\") + 1);
			// 파일사이즈
			long size = file.getSize();
			// 동일한 파일을 재업로드시 기존파일 덮어버리기 때문에, 난수 이름으로 파일명을 바꿔서 올림
			String uuid = UUID.randomUUID().toString();
			// 날짜별로 폴더 생성
			String filepath = makeFolder();
			// 세이브할 경로
			String savepath = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
			// 데이터베이스 추후에 저장
			// System.out.println(originName);
			// System.out.println("사이즈 : "+size);
			System.out.println("uuid : " + uuid);
			System.out.println("실제 파일명 : " + filename);
			System.out.println("??" + uploadPath);
			System.out.println("날짜폴더경로 : " + filepath);
			System.out.println("세이브 할 경로 : " + savepath);
			System.out.println("-------------------------------------------------");
			try {
				File saveFile = new File(savepath);
				file.transferTo(saveFile);
			} catch (Exception e) {
				System.out.println("파일업로드 중 error 발생");
				e.printStackTrace();
			}
		}
		return "upload/upload_ok";
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

}
