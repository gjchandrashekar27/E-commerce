package com.e_commerce.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private String imageUrl;
	@Enumerated(EnumType.STRING)
	private Status status;
	@UpdateTimestamp
	private LocalDateTime createdTime;

	@ManyToOne
	Merchant merchant;

}
