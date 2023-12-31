package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

class Dummy{
	private String fname;
	private String sname;

	public Dummy(String fname,String sname){
		this.fname = fname;
		this.sname = sname;
	}
}

@RestController
public class Container {
	@GetMapping("/index")
	public Dummy home() {
		System.out.print("KHGJHGJHFGJHG");
		Dummy d = new Dummy("Ram","Sundar");
		return d;
	}
}
