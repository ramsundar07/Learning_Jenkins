package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Container {
	@RequestMapping("/")
	public String home() {
		System.out.print("KHGJHGJHFGJHG");
		return "home.jsp";
	}
}
