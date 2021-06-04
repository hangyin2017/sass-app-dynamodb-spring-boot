package com.demo.dynamodb.services;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.dtos.user.UserGetDto;
import com.demo.dynamodb.dtos.user.UserPostDto;
import com.demo.dynamodb.dtos.user.UserPutDto;
import com.demo.dynamodb.entities.user.User;
import com.demo.dynamodb.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.answer;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class UserServiceTest {

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	@DisplayName("list should return user list")
	void list() {
		// Given
		User user1 = new User();
		user1.setUserId("user-1");
		User user2 = new User();
		user2.setUserId("user-2");

		given(userRepository.findAll(PageRequest.of(0, 20)))
				.willReturn(new PageImpl<>(List.of(user1, user2)));

		// When
		List<UserGetDto> returnedUsers = userService.list(PageRequest.of(0, 20));

		// Then
		assertEquals(2, returnedUsers.size());
	}

	@Test
	@DisplayName("addOne should save user given userPostDto")
	void addOne() {
		// Given
		UserPostDto userPostDto = new UserPostDto();
		userPostDto.setUsername("user1");
		userPostDto.setRole(Set.of(Role.ADMIN));

		given(userRepository.save(any(User.class))).willAnswer(answer(user -> user));

		// When
		UserGetDto savedUser = userService.addOne(userPostDto);

		// Then
		assertEquals("user1", savedUser.getUsername());
	}

	@Test
	@DisplayName("findByRole should return user given role")
	void findByRole() {
		// Given
		User user1 = new User();
		user1.setUserId("user-1");
		user1.setRole(Set.of(Role.ADMIN.toString()));
		User user2 = new User();
		user2.setUserId("user-2");
		user1.setRole(Set.of(Role.ADMIN.toString(), Role.MANAGER.toString()));

		given(userRepository.findByRole(Role.ADMIN)).willReturn(List.of(user1, user2));

		// When
		List<UserGetDto> returnedUsers = userService.findByRole(Role.ADMIN);

		// Then
		assertEquals(2, returnedUsers.size());
	}

	@Test
	@DisplayName("findByCompanyId should return user list given companyId")
	void findByCompanyId() {
		// Given
		String companyId = "company-1";
		User user1 = new User();
		user1.setUserId("user-1");
		user1.setCompanyId(companyId);
		User user2 = new User();
		user2.setUserId("user-2");
		user2.setCompanyId(companyId);

		given(userRepository.findByCompanyId(companyId)).willReturn(List.of(user1, user2));

		// When
		List<UserGetDto> returnedUsers = userService.findByCompanyId(companyId);

		// Then
		assertEquals(2, returnedUsers.size());
	}

	@Test
	@DisplayName("update should update user given userPutDto")
	void update() {
		// Given
		String userId = "user-1";
		String userName = "userName1";
		UserPutDto userPutDto = new UserPutDto();
		userPutDto.setUserId(userId);
		userPutDto.setUsername(userName);
		userPutDto.setRole(Set.of(Role.ADMIN, Role.MANAGER));

		User user1 = new User();
		user1.setUserId(userId);

		given(userRepository.findByUserId(userId)).willReturn(Optional.of(user1));
		given(userRepository.save(any(User.class))).willAnswer(answer(user -> user));

		// When
		UserGetDto updatedUser = userService.update(userPutDto);

		// Then
		assertEquals(userName, updatedUser.getUsername());
		assertTrue(updatedUser.getRole().contains(Role.ADMIN.toString()));
		assertTrue(updatedUser.getRole().contains(Role.MANAGER.toString()));
	}
}