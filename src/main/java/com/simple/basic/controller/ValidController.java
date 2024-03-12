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

import com.simple.basic.command.ValidVO;

@Controller
@RequestMapping("/valid")
public class ValidController {

	@GetMapping("/ex01")
	public String ex01() {
		
		return "valid/ex01";
	}
	
	@PostMapping("/validForm")
	public String validForm(@Valid ValidVO vo, Errors errors, Model model ) {
		
		// 유효성 검사의 실패한 목록을 Errors 안에 바인딩 시킨다.
		
		// error 발생된 목록이 있다면 true
		if(errors.hasErrors()) {
			List<FieldError> list =  errors.getFieldErrors();
			
			for( FieldError err : list) {
				String field = err.getField(); // 유효성 검사에 실패한 변수명
				String message =  err.getDefaultMessage(); // 유효성 검사에 실패한 변수 메세지
				
				if(err.isBindingFailure()) {
					model.addAttribute("valid_"+field, "숫자로 입력하세요.");
				}else {
					model.addAttribute("valid_"+field, message);	
				}
			}
			
			model.addAttribute("vo", vo); // 원본데이터를 들고나감
			
			return "valid/ex01";
		}
		
		
		
		// 데이터 베이스 처리도 이곳에서
		
		System.out.println(vo.toString());
		
		return "valid/ex01_result";
	}
	
	@GetMapping("/ex02")
	public String ex02() {
		return "valid/ex02";
	}
}
