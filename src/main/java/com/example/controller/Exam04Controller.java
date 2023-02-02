package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	@GetMapping("")
	public String index(UserForm form) {
		return "exam04";
	}

	@PostMapping("/to-result")
	public String toResult(UserForm form, Model model) {
		User user = new User();
		user.setName(form.getName());
		user.setAge(form.getIntAge());
		user.setComment(form.getComment());
		model.addAttribute("user", user);
		return "exam04-result";
	}

}
