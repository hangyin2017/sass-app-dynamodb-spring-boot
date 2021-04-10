package com.demo.dynamodb.dtos.company;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
public class CompanyPostDto {

	@NotBlank
	private String companyName;

	private String address;
	private String country;
	private String city;

	@URL
	private String url;

	private String introduction;
	private String businessNumber;
}
