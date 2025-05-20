package com.e_commerce.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.e_commerce.dto.UserDto;
import com.e_commerce.entity.Admin;
import com.e_commerce.helper.AES;
import com.e_commerce.helper.EmailSender;
import com.e_commerce.repository.AdminRepository;
import com.e_commerce.repository.CustomerRepository;
import com.e_commerce.repository.MerchantRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MerchantRepository merchantRepository;
	
	@Autowired
	EmailSender emailSender;

	@Override
	public String register(UserDto userDto, Model model) {
		model.addAttribute("userDto", userDto);
		return "admin-register.html";
	}

	
		@Override
		public String register(UserDto userDto, BindingResult result, HttpSession session) {
			if (!userDto.getPassword().equals(userDto.getConfirmPassword()))
				result.rejectValue("confirmPassword", "error.confirmPassword",
						"* Password and Confirm password not matching");
			if (adminRepository.existsByEmail(userDto.getEmail()) || customerRepository.existsByEmail(userDto.getEmail())
					|| merchantRepository.existsByEmail(userDto.getEmail()))
				result.rejectValue("email", "error.email", "* Email Already Exists");
			
			if (result.hasErrors()) {
				return "admin-register.html";
			}
			
			int otp = new Random().nextInt(100000, 1000000);
			emailSender.sendEmail(userDto, otp);

			session.setAttribute("otp", otp);
			session.setAttribute("userDto", userDto);
			session.setAttribute("pass", "Otp Sent Success");
			return "redirect:/admin/otp";
		}


		@Override
		public String sumbitOtp(int otp, HttpSession session) {
			int generatedOtp = (int) session.getAttribute("otp");
			if (generatedOtp == otp) {
				UserDto dto = (UserDto) session.getAttribute("userDto");
				Admin admin = new Admin();
				admin.setEmail(dto.getEmail());
				admin.setName(dto.getName());
				admin.setPassword(AES.encrypt(dto.getPassword()));
				adminRepository.save(admin);
				session.setAttribute("pass", "Account Created Success");
				return "redirect:/";
			} else {
				session.setAttribute("fail", "Otp Missmatch");
				return "redirect:/admin/otp";
			}
			
		}
	}

	


