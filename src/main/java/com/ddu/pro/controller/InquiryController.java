package com.ddu.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String cs(Model model) {
		
		String bn_id = "admin";
		List<LodgmentVO> lodgVO =csService.getLodgName(bn_id);
		model.addAttribute("lodgVO", lodgVO);
		List<InquiryVO> list2 = csService.getAll();
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

}
