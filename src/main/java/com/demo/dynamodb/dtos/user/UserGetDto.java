package com.demo.dynamodb.dtos.user;

import com.demo.dynamodb.constants.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserGetDto {

	String userId;
	String username;
	String email;
	Boolean isVerified;
	List<String> role;
	String companyId;
}
