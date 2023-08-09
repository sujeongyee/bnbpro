package com.ddu.pro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddu.pro.command.InquiryVO;
import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.service.CSSerivce;


@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	
	@Autowired
	@Qualifier("csSerivce")
	private CSSerivce csService;
	
	@GetMapping("/cs")
	public String cs(Model model,HttpSession session) {
		
		String bn_id = session.getAttribute("userid").toString();
		List<LodgmentVO> lodgVO =csService.getLodgName(bn_id);
		model.addAttribute("lodgVO", lodgVO);
		List<InquiryVO> list2 = csService.getAll(bn_id);
		for(InquiryVO vo : list2) {
			System.out.println(vo.toString());
		}
		model.addAttribute("list2", list2);
		return "inquiry/cs";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("lodg") String lodg , Model model, RedirectAttributes ra) {

		List<InquiryVO> list = csService.getLodgIngury(lodg);
		ra.addFlashAttribute("list",list);
		/*
		 * List<InquiryVO> list2 = csService.getAll(); ra.addAttribute("list2", list2);
		 */
		return "redirect:/inquiry/cs";
	}
	
	@PostMapping("/getData")
	public ResponseEntity<List<InquiryVO>> getData(@RequestBody Map<String,String> map) {
		
		String a = map.get("ask_num");
		List<InquiryVO> list = csService.getAnswer(a);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping("/registData")
	public ResponseEntity<String> registData(@RequestBody Map<String,String> map) {
		

		csService.registAnswer(map.get("answer_content"),Integer.parseInt(map.get("ask_num")));
		csService.check(Integer.parseInt(map.get("ask_num")));
		return new ResponseEntity<>(map.get("answer_content"),HttpStatus.OK);
	}

}
