package com.demo.dynamodb.dtos.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserPostDto {

	@NotBlank
	String username;

	@NotBlank
	String email;
}
