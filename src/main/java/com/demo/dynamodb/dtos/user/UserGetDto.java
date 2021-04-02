package com.demo.dynamodb.dtos.user;

import lombok.Data;

@Data
public class UserGetDto {

	String userId;
	String username;
	String email;
	Boolean isVerified;
	String role;
	String companyId;
}
