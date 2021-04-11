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
import java.util.Set;
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
		Set<Role> roleSet = userPostDto.getRole();
		user.setRole(roleSet.stream()
				.map(Role::toString)
				.collect(Collectors.toSet()));

		User savedUser = userRepository.save(user);
		return userMapper.fromEntity(savedUser);
	}

	public List<UserGetDto> findByRole(Role role) {
		List<User> users = userRepository.findByRole(role);
		return users.stream().map(userMapper::fromEntity).collect(Collectors.toList());
	}

	public List<UserGetDto> findByCompanyId(String companyId) {
		List<User> users = userRepository.findByCompanyId(companyId);
		return users.stream().map(userMapper::fromEntity).collect(Collectors.toList());
	}
}
