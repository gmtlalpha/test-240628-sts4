package com.rho.wish.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Wish { 
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String itemName;
	
	@JsonProperty
	private String itemCategory;

	@JsonProperty
	private Long itemCode;

}
