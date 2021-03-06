package com.demo.dynamodb.dtos.company;

import lombok.Data;

@Data
public class CompanyGetDto {

	private String companyId;
	private String companyName;
	private String address;
	private String country;
	private String city;
	private String url;
	private String introduction;
	private String businessNumber;
}
