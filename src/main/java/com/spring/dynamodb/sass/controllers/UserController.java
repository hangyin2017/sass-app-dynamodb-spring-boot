package com.spring.dynamodb.sass.controllers;

import com.spring.dynamodb.sass.entities.User;
import com.spring.dynamodb.sass.repositories.UserRepository;
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
	UserRepository userRepository;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> users = (List<User>) userRepository.findAll();
		return ResponseEntity.ok(users);
	}

	@PostMapping
	public ResponseEntity<User> addOne() {
		User user = new User();
		user.setUsername("user1");
		User savedUser = userRepository.save(user);
		return ResponseEntity.ok(savedUser);
	}
}
