package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	@GetMapping("")
	public String index(UserForm form,Model model) {
		return "exam04";
	}

	@PostMapping("/register-user")
	public String registerUser(@Validated UserForm form,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return index(form,model);
		}
		
		User user = new User();
		BeanUtils.copyProperties(form, user);
		user.setAge(form.getIntAge());

		model.addAttribute("user", user);
		return "exam04-result";
	}

}
