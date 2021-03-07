package com.spring.dynamodb.sass.controllers;

import com.spring.dynamodb.sass.entities.User;
import com.spring.dynamodb.sass.repositories.UserRepository;
import com.spring.dynamodb.sass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAll();
		return ResponseEntity.ok(users);
	}

	@PostMapping
	public ResponseEntity<User> addOne() {
		User savedUser = userService.addOne();
		return ResponseEntity.ok(savedUser);
	}
}
