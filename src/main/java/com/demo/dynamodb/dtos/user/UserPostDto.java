package com.demo.dynamodb.dtos.user;

import com.demo.dynamodb.constants.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserPostDto {

	@NotBlank
	String username;

	@NotBlank
	String email;

	@NotNull
	List<Role> role;

	String companyId;
}
