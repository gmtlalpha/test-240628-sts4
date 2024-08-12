package com.rho.wish.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Wish { 
	//VO 
	//BTO data transfer object 
	// repository
	// 자바 빈즈(Java Beans)
	// setter getter 만
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String title;
	
	@JsonProperty
	private String info;

	@JsonProperty
	private String country;
	
	@JsonProperty
	private Long countryCode;

}
