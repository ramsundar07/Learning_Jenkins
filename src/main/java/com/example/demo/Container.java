package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Container {
	@GetMapping("/home")
	public String home() {
		System.out.print("KHGJHGJHFGJHG");
		return "hi";
	}
}
