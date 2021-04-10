package com.demo.dynamodb.services;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.dtos.user.UserGetDto;
import com.demo.dynamodb.dtos.user.UserPostDto;
import com.demo.dynamodb.entities.user.User;
import com.demo.dynamodb.mappers.UserMapper;
import com.demo.dynamodb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	public List<UserGetDto> list() {
		List<User> users = userRepository.findAll();
		List<UserGetDto> userGetDtos = users.stream()
				.map(userMapper::fromEntity)
				.collect(Collectors.toList());
		return userGetDtos;
	}

	public UserGetDto addOne(UserPostDto userPostDto) {
		User user = userMapper.toEntity(userPostDto);
		user.setIsVerified(false);
		//user.setRole(userPostDto.getRole().toString());

		User savedUser = userRepository.save(user);
		return userMapper.fromEntity(savedUser);
	}
}
