package com.demo.dynamodb.dtos.user;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class UserGetDto {

	String userId;
	Date updatedAt;
	Date createdAt;
	String username;
	String email;
	Boolean isVerified;
	Set<String> role;
	String companyId;
}
