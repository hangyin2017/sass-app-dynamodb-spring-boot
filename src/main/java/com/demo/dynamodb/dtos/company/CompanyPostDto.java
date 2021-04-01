package com.demo.dynamodb.dtos.company;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CompanyPostDto {

	@NotBlank
	private String companyName;

	private String address;
	private String country;
	private String city;
	private String url;
	private String introduction;
	private String businessNumber;
}
