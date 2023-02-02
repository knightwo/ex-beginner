package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	@Autowired
	private HttpSession session;
	
	@GetMapping("")
	public String index() {
		return "exam02";
	}
	
	@PostMapping("/to-result")
	public String toResult(Integer num1,Integer num2) {
		Integer addResult = num1 + num2;
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("addResult", addResult);
		return "exam02-result";
	}
	
	@GetMapping("/to-result2")
	public String toResult2() {
		return "exam02-result2";
	}

}
