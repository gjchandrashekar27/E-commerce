package com.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	boolean existsByEmail(String email);

}
