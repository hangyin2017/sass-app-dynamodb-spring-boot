package com.demo.dynamodb.dtos.user;

import com.demo.dynamodb.constants.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserPostDto {

	@NotBlank
	String username;

	@NotBlank
	String email;

	@NotNull
	Role role;

	String companyId;
}
