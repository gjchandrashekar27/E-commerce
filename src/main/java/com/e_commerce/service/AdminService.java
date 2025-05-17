package com.e_commerce.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.e_commerce.dto.UserDto;

import jakarta.validation.Valid;

public interface AdminService {

	String register(UserDto userDto, Model model);

	String register( UserDto userDto, BindingResult result);

}
