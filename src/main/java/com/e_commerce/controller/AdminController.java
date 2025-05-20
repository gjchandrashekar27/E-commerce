package com.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.e_commerce.dto.UserDto;
import com.e_commerce.service.AdminService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/register")
	public String loadRegister(UserDto userDto, Model model) {
		return adminService.register(userDto,model);
	}

	@PostMapping("/register")
	public String register(@Valid UserDto userDto , BindingResult result, HttpSession session) {
		return adminService.register(userDto,result,session);
	}

}
