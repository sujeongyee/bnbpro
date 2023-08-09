package com.ddu.pro.controller;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddu.pro.command.ReviewImgVO;
import com.ddu.pro.command.ReviewVO;
import com.ddu.pro.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	@Qualifier("reviewService")
	private ReviewService reviewService;
	
	@Value("${project.upload.path}")
	private String uploadPath;
	
	@GetMapping("/reviewList")
	public String reviewList(Model model) {
		
		ArrayList<ReviewVO> list = reviewService.getList();
		System.out.println(list);
		model.addAttribute("list", list);
		
		return "review/reviewList";
	}
	
	
	@GetMapping("/reviewDetail")
	public String detail(@RequestParam("rev_num") int rev_num, Model model,
						 @RequestParam("user_id") String user_id) {
		
		ReviewVO vo = reviewService.getDetail(rev_num);
		model.addAttribute("vo", vo);
		
		ArrayList<ReviewImgVO> list = reviewService.getImg(user_id);
		model.addAttribute("list", list);
		
		return "review/reviewDetail";
	}
	
	@GetMapping("/display")
	@ResponseBody
	public byte[] display(@RequestParam("filepath") String filepath,
						  @RequestParam("uuid") String uuid,
						  @RequestParam("filename") String filename) {
		
		String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
		File file = new File(path);
		
		byte[] data = null;
		
		try {
			data = FileCopyUtils.copyToByteArray(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
