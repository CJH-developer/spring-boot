	
package com.simple.basic.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute( "serverTime", new Date() );
		model.addAttribute( "name", "홍길동");
		
		return "hello";
	}
	
}