package com.spring.dynamodb.sass.services;

import com.spring.dynamodb.sass.entities.User;
import com.spring.dynamodb.sass.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User addOne() {
		User user = new User();
		user.setUsername("user1");
		return userRepository.save(user);
	}
}
