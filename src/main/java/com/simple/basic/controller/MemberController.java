package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.MemberVO;

@Controller
@RequestMapping("/valid")
public class MemberController {

	@GetMapping("/quiz01")
	public String quiz01() {
		return "valid/quiz01";
	}
	
	@PostMapping("/quizForm")
	public String quizForm(@Valid MemberVO vo, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			
			List<FieldError> list =  errors.getFieldErrors();
			
			for( FieldError err : list) {
				String field = err.getField(); // 유효성 검사에 실패한 변수명
				String message =  err.getDefaultMessage(); // 유효성 검사에 실패한 변수 메세지
				
				
				model.addAttribute("valid_"+field, message);	
			
			}
			
			model.addAttribute("vo", vo); // 원본데이터를 들고나감
			
			return "valid/quiz01";
		}
		return "valid/quiz01_result";
	}
	
	@GetMapping("/quiz01_result")
	public String quiz01_result(MemberVO vo, Model model) {
		
		model.addAttribute("vo", vo);
		
		return "valid/quiz01_result";
	}
	
}
