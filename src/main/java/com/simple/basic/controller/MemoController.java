package com.simple.basic.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.MemoVO;
import com.simple.basic.service.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	@Qualifier("MemoService")	
	private MemoService service;
	
	@GetMapping("/memoWrite")
	public String memoWrite() {
		return "memo/memoWrite";
	}
	
	@PostMapping("/memoForm")
	public String memoForm(MemoVO vo) {
		
		service.regist(vo);
		
		return "redirect:/memo/memoList";
	}
	
	@GetMapping("/memoList")
	public String memoList(Model model) {
		
		ArrayList<MemoVO> list = service.getList();
		
		model.addAttribute("vo" , list);
		System.out.println(list.toString());
		
		return "memo/memoList";
	}
}
