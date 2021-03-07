package com.spring.dynamodb.sass.services;

import com.spring.dynamodb.sass.dtos.user.UserGetDto;
import com.spring.dynamodb.sass.dtos.user.UserPostDto;
import com.spring.dynamodb.sass.entities.User;
import com.spring.dynamodb.sass.mappers.UserMapper;
import com.spring.dynamodb.sass.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	public List<UserGetDto> getAll() {
		List<User> users = userRepository.findAll();
		List<UserGetDto> userGetDtos = users.stream()
				.map(userMapper::fromEntity)
				.collect(Collectors.toList());
		return userGetDtos;
	}

	public UserGetDto addOne(UserPostDto userPostDto) {
		User user = userMapper.toEntity(userPostDto);
		user.setIsVerified(false);
		User savedUser = userRepository.save(user);
		return userMapper.fromEntity(savedUser);
	}
}
