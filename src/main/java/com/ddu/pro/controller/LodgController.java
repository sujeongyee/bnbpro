package com.ddu.pro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	// 숙소 등록하기 기능
	@PostMapping("/lodgregist")
	public String lodgregist(LodgmentVO vo ,@RequestParam("file") List<MultipartFile> list, RedirectAttributes ra) {

		
		list = list.stream().filter(p->p.isEmpty()==false).collect(Collectors.toList());
	
		
		for(MultipartFile file: list) {
			if(file.getContentType().contains("image")==false) {
				ra.addFlashAttribute("msg", "이미지 파일만 등록이 가능합니다");
				return "redirect:/lodgment/regist"; // 이미지가 아니라면 list목록으로
			}
		}
		
		lodgmentSerivce.lodgmentRegist(vo, list);
		ra.addFlashAttribute("msg", "등록이 완료 됐습니다!");
		return "redirect:/main";
	}
	
	// 수정하기 버튼 누르면 페이지 이동 (숙소 상세 정보 가지고)
	@GetMapping("/lodgupdate")
	public String lodgupdate(@RequestParam("lodg_num") String lodg_num,Model model) {

		LodgmentVO vo = lodgmentSerivce.getLodgment(lodg_num);
		model.addAttribute("vo", vo);
		return "lodgment/updatelodg";
	}
	
	@GetMapping("/lodgdelete")
	public String lodgdelte(@RequestParam("lodg_num") String lodg_num) {
		lodgmentSerivce.deleteLodg(lodg_num);
		return "redirect:/main";
	}
	

}
