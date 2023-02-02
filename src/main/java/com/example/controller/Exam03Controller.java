package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	@Autowired
	private ServletContext application;
	
	@GetMapping("")
	public String index() {
		return "exam03";
	}
	
	@PostMapping("/to-result")
	public String toResult(Integer itemPrice1,Integer itemPrice2,Integer itemPrice3) {
		Integer nonTaxedPrice     = itemPrice1 + itemPrice2 + itemPrice3;
		Integer includingTaxPrice = nonTaxedPrice + (nonTaxedPrice / 10);
		application.setAttribute("nonTaxedPrice", nonTaxedPrice);
		application.setAttribute("includingTaxPrice", includingTaxPrice);
		return "exam03-result";
		
	}

}
