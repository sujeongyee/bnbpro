package com.ddu.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.service.LodgmentService;

@Controller
@RequestMapping("/lodgment")
public class LodgController {
	
	@Autowired
	@Qualifier("lodgmentService")
	private LodgmentService lodgmentSerivce;
	
	@GetMapping("/regist")
	public String registlodg() {
		
		return "lodgment/regist";
	}
	@PostMapping("/lodgregist")
	public String lodgregist(LodgmentVO vo ,@RequestParam("file") List<MultipartFile> list, RedirectAttributes ra) {

		
		list = list.stream().filter(p->p.isEmpty()==false).toList();
		
		for(MultipartFile file: list) {
			if(file.getContentType().contains("image")==false) {
				ra.addFlashAttribute("msg", "이미지 파일만 등록이 가능합니다");
				return "redirect:/lodgment/regist"; // 이미지가 아니라면 list목록으로
			}
		}
		
		lodgmentSerivce.lodgmentRegist(vo, list);
		System.out.println("여기가 문제인가");
		ra.addFlashAttribute("msg", "등록이 완료 됐습니다!");
		return "redirect:/main";
	}
	
	

}
