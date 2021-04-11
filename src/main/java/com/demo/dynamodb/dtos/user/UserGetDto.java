package com.demo.dynamodb.dtos.user;

import lombok.Data;

import java.util.Set;

@Data
public class UserGetDto {

	String userId;
	String username;
	String email;
	Boolean isVerified;
	Set<String> role;
	String companyId;
}
