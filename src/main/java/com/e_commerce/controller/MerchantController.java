package com.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e_commerce.dto.UserDto;
import com.e_commerce.service.MerchantService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/merchant")
public class MerchantController {
	
	@Autowired
	MerchantService merchantService;

	@GetMapping("/register")
	public String loadRegister(UserDto userDto, Model model) {
		return merchantService.register(userDto, model);
	}

	@PostMapping("/register")
	public String register(@Valid UserDto userDto, BindingResult result) {
		return merchantService.register(userDto, result);
	}

}
