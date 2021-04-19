package com.demo.dynamodb.services;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.dtos.user.UserGetDto;
import com.demo.dynamodb.dtos.user.UserPostDto;
import com.demo.dynamodb.dtos.user.UserPutDto;
import com.demo.dynamodb.entities.user.User;
import com.demo.dynamodb.entities.user.UserCompositeKey;
import com.demo.dynamodb.mappers.UserMapper;
import com.demo.dynamodb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	public List<UserGetDto> list(Integer page, Integer size) {
		Page<User> users = userRepository.findAll(PageRequest.of(page, size));
		List<UserGetDto> userGetDtos = users.stream()
				.map(userMapper::fromEntity)
				.collect(Collectors.toList());
		return userGetDtos;
	}

	public UserGetDto addOne(UserPostDto userPostDto) {
		User user = userMapper.toEntity(userPostDto);
		user.setIsVerified(false);
		user.setRole(convertRoles(userPostDto.getRole()));

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

	public UserGetDto update(UserPutDto userPutDto) throws NoSuchElementException {
		User user = userRepository.findById(new UserCompositeKey(userPutDto.getUserId(), userPutDto.getCreatedAt()))
				.orElseThrow(() -> new NoSuchElementException("No such user"));
		userMapper.copy(userPutDto, user);
		user.setRole(convertRoles(userPutDto.getRole()));
		return userMapper.fromEntity(userRepository.save(user));
	}

	// Converts role enums to lowercase
	private Set<String> convertRoles(Set<Role> roleSet) {
		return roleSet.stream().map(Role::toString).collect(Collectors.toSet());
	}
}
