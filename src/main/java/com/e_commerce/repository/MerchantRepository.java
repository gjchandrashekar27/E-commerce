package com.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.entity.Merchant;

public interface MerchantRepository  extends JpaRepository<Merchant, Long>{

	boolean existsByEmail(String email);

}
