package com.demo.dynamodb.dtos.user;

import com.demo.dynamodb.constants.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Set;

@Data
public class UserPutDto {

	@NotBlank String userId;
	String username;
	String email;
	Set<Role> role;
	String companyId;
}
