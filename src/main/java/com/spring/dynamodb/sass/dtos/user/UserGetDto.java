package com.spring.dynamodb.sass.dtos.user;

import lombok.Data;

@Data
public class UserGetDto {

	String userId;
	String username;
	String email;
	Boolean isVerified;
}
