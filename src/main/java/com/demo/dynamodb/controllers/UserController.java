package com.demo.dynamodb.controllers;

import com.demo.dynamodb.dtos.user.UserGetDto;
import com.demo.dynamodb.dtos.user.UserPostDto;
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
	public List<UserGetDto> list() {
		List<UserGetDto> userList = userService.list();
		return userList;
	}

	@PostMapping
	public UserGetDto addOne(@RequestBody @Valid UserPostDto userPostDto) {
		UserGetDto savedUser = userService.addOne(userPostDto);
		return savedUser;
	}
}
