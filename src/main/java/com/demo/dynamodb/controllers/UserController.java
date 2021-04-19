package com.demo.dynamodb.controllers;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.dtos.user.UserGetDto;
import com.demo.dynamodb.dtos.user.UserPostDto;
import com.demo.dynamodb.dtos.user.UserPutDto;
import com.demo.dynamodb.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<UserGetDto> list(@RequestParam Integer page, @RequestParam Integer size) {
		List<UserGetDto> userList = userService.list(page, size);
		return userList;
	}

	// Note: Role is lower-case
	@PostMapping
	public UserGetDto addOne(@RequestBody @Valid UserPostDto userPostDto) {
		UserGetDto savedUser = userService.addOne(userPostDto);
		return savedUser;
	}

	@GetMapping("/companyId")
	public List<UserGetDto> findByCompanyId(@RequestParam String companyId) {
		List<UserGetDto> users = userService.findByCompanyId(companyId);
		return users;
	}

	// Example: api/v1/users/role?role=intern
	@GetMapping("/role")
	public List<UserGetDto> findByRole(@RequestParam String role) {
		List<UserGetDto> users = userService.findByRole(Role.valueOf(role.toUpperCase()));
		return users;
	}

	@PutMapping
	public UserGetDto update(@RequestBody @Valid UserPutDto userPutDto) {
		return userService.update(userPutDto);
	}
}
