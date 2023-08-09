package com.ddu.pro.controller;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddu.pro.command.BusinessVO;
import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.command.LoginVO;
import com.ddu.pro.command.ResVO;
import com.ddu.pro.command.TestVO;
import com.ddu.pro.service.BusinessService;
import com.ddu.pro.service.LodgmentService;
import com.ddu.pro.service.TestService;
import com.ddu.pro.util.Criteria2;
import com.ddu.pro.util.PageVO2;

@Controller
public class MainController {

	@Autowired
	@Qualifier("businessService")
	private BusinessService businessService;

	@Autowired
	@Qualifier("lodgmentService")
	private LodgmentService lodgmentSerivce;

	@Value("${project.upload.path}")
	private String uploadPath;

	@Autowired
	TestService testService;


	@GetMapping("/join")
	public String join(Model model) {
		model.addAttribute("vo", new BusinessVO());
		return "join";
	}

	// 모든 숙소 정보 리스트 가지고 메인으로
	@GetMapping("/main")
	public String main(Model model, Criteria2 cri, HttpSession session) {

		System.out.println(session.getAttribute("userid")+"ddd");
		
		
		String bn_id = "admin";
		PageVO2 page = new PageVO2(cri, lodgmentSerivce.getTotal(bn_id, cri));
		List<LodgmentVO> list = lodgmentSerivce.getLodgList(bn_id, cri);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "main";
	}

	// 메인에서 이미지 출력해주는 메서드
	@GetMapping("/display")
	public @ResponseBody ResponseEntity<byte[]> display(@RequestParam("filename") String filename,
			@RequestParam("filepath") String filepath, @RequestParam("uuid") String uuid) {

		String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
		File file = new File(path);
		byte[] arr = null;
		try {
			arr = FileCopyUtils.copyToByteArray(file); // 파일경로기반으로 데이터를 구함
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(arr, HttpStatus.OK);
	}

	@GetMapping("/calendar")
	public String calendar() {
		return "calendar";
	}

	@GetMapping("/test")
	public @ResponseBody ResponseEntity<List<com.ddu.pro.command.TestVO>> test() {
		System.out.println("d");
		return new ResponseEntity<List<TestVO>>(testService.getTest(), HttpStatus.OK);
	}
	// 테스트 ddu 로 들어옴

	///////////////////////////////////// 가영
	
	// register 를 join으로 대체
//   @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("business", new BusinessVO());
//        return "business/register";
//    }
   
	@PostMapping("/join")
	public String actionForm(@Valid @ModelAttribute("vo") BusinessVO vo, Errors error, Model model,
								RedirectAttributes ra) {
		System.out.println(vo.toString());
		if (error.hasErrors()) {
			System.out.println("에러");
			List<FieldError> list = error.getFieldErrors();
			for (FieldError err : list) {

				if (err.isBindingFailure()) {
					model.addAttribute("valid_" + err.getField(), "형식이 올바르지 않습니다");
					System.out.println(err.getField());
					System.out.println(err.getDefaultMessage());
				} else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
					System.out.println(err.getField());
					System.out.println(err.getDefaultMessage());
				}
				
			} //end for
			model.addAttribute("vo", vo);
			return "join";// 원래 화면으로

		}

		int result = businessService.registerBusiness(vo);

		if (result == 1) {

			ra.addFlashAttribute("msg", "중복된 사용자 ID입니다.");
			return "redirect:/join";
		}

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {

		return "login";
	}

	@PostMapping("/loginForm")
	public String loginUser(@ModelAttribute("vo") LoginVO vo, RedirectAttributes ra, Errors error, Model model, HttpSession session) {
		
//		if (error.hasErrors()) {
//			List<FieldError> list = error.getFieldErrors();
//			for (FieldError err : list) {
//
//				if (err.isBindingFailure()) {
//					model.addAttribute("valid_" + err.getField(), "형식이 올바르지 않습니다");
//					System.out.println(err.getField());
//					System.out.println(err.getDefaultMessage());
//				} else {
//					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
//					System.out.println(err.getField());
//					System.out.println(err.getDefaultMessage());
//				}
//				
//			} //end for
//			model.addAttribute("vo", vo);
//			return "login";// 원래 화면으로
//		}
		
		if(vo.getBn_id().equals("") || vo.getBn_pw().equals("")) {
			model.addAttribute("msg", "아이디와 비밀번호를 모두 입력해주세요.");
			model.addAttribute("vo", vo);
			return "login";
		}

		int result = businessService.loginBusiness(vo, session);

		if (result == 1) {
			model.addAttribute("msg", "아이디를 정확히 입력해주세요.");
			model.addAttribute("vo", vo);
			System.out.println("아이디");
			return "login";
		}

		if (result == 2) {
			model.addAttribute("msg", "비밀번호를 정확히 입력해주세요.");
			model.addAttribute("vo", vo);
			System.out.println("비번");
			return "login";
		}

		return "redirect:/main";
	}
	
	
	// 메인페이지 대신 임시 페이지
	@GetMapping("/temp")
	public String temp() {
		return "temp";
	}

	@PostMapping("/check_duplicate")
	@ResponseBody
	public ResponseEntity<?> checkDuplicate(@RequestParam String bn_id) {
		
        final Pattern pattern = Pattern.compile("[a-zA-Z0-9]{8,}", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(bn_id);
        if(!matcher.matches()) {
			return new ResponseEntity<>(
					ResVO.builder()
					.code(1)
					.message("아이디는 영문자, 숫자 8자 이상이어야 합니다.")
					.build(),
					HttpStatus.BAD_REQUEST
			);
        }
		
		if(bn_id == null || bn_id.equals("")) {
			return new ResponseEntity<>(
					ResVO.builder()
					.code(1)
					.message("아이디를 입력해주세요.")
					.build(),
					HttpStatus.BAD_REQUEST
			);
		}

		int result = businessService.checkDuplicate(bn_id);

		if (result == 1) {

			return new ResponseEntity<>(ResVO.builder().code(1).message("중복된 사용자 ID입니다.").build(),
					HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(ResVO.builder().code(1).message("사용가능한 ID입니다.").build(), HttpStatus.OK);

	}

}