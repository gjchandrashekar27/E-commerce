package com.e_commerce.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.e_commerce.dto.UserDto;

public interface MerchantService {

	String register(UserDto userDto, Model model);
	
	String register(UserDto userDto, BindingResult  result);

}
