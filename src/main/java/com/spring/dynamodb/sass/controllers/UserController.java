package com.spring.dynamodb.sass.controllers;

import com.spring.dynamodb.sass.dtos.user.UserGetDto;
import com.spring.dynamodb.sass.dtos.user.UserPostDto;
import com.spring.dynamodb.sass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<UserGetDto>> getAll() {
		List<UserGetDto> users = userService.getAll();
		return ResponseEntity.ok(users);
	}

	@PostMapping
	public ResponseEntity<UserGetDto> addOne(@RequestBody UserPostDto userPostDto) {
		UserGetDto savedUser = userService.addOne(userPostDto);
		return ResponseEntity.ok(savedUser);
	}
}
