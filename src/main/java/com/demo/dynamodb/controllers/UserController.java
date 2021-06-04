package com.demo.dynamodb.controllers;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.dtos.user.UserGetDto;
import com.demo.dynamodb.dtos.user.UserPostDto;
import com.demo.dynamodb.dtos.user.UserPutDto;
import com.demo.dynamodb.services.UserService;
import lombok.RequiredArgsConstructor;
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
		return userService.list(page, size);
	}

	// Note: Role is lower-case
	@PostMapping
	public UserGetDto addOne(@RequestBody @Valid UserPostDto userPostDto) {
		return userService.addOne(userPostDto);
	}

	@GetMapping("/companyId")
	public List<UserGetDto> findByCompanyId(@RequestParam String companyId) {
		return userService.findByCompanyId(companyId);
	}

	// Example: api/v1/users/role?role=intern
	@GetMapping("/role")
	public List<UserGetDto> findByRole(@RequestParam String role) {
		return userService.findByRole(Role.valueOf(role.toUpperCase()));
	}

	@PutMapping
	public UserGetDto update(@RequestBody @Valid UserPutDto userPutDto) {
		return userService.update(userPutDto);
	}
}
