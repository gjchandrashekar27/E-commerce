package com.e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.e_commerce.dto.UserDto;
import com.e_commerce.entity.Admin;
import com.e_commerce.entity.Merchant;
import com.e_commerce.repository.AdminRepository;
import com.e_commerce.repository.CustomerRepository;
import com.e_commerce.repository.MerchantRepository;

@Service
public class CustomerServiceImpl  implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	MerchantRepository merchantRepository;

	@Override
	public String register(UserDto userDto, Model model) {
		model.addAttribute("userDto", userDto);
		return "customer-register.html";
		
	}

	@Override
	public String register(UserDto userDto, BindingResult result) {
		if (!userDto.getPassword().equals(userDto.getConfirmPassword()))
			result.rejectValue("confirmPassword", "error.confirmPassword",
					"* Password and Confirm password not matching");
		if (adminRepository.existsByEmail(userDto.getEmail()) || customerRepository.existsByEmail(userDto.getEmail())
				|| merchantRepository.existsByEmail(userDto.getEmail()))
			result.rejectValue("email", "error.email", "* Email Already Exists");
		
		if (result.hasErrors()) {
			return "customer-register.html";
		}
		
		return "redirect:/";
	}
	}
		 


	


