package com.demo.dynamodb.repositories;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.entities.user.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@BeforeEach
	void init(TestInfo testInfo) {
		if(testInfo.getTags().contains("SkipInit")) {
			return;
		}

		User user1 = new User();
		user1.setCompanyId("company-1");
		user1.setRole(Set.of(Role.ADMIN.toString()));
		User user2 = new User();
		user2.setCompanyId("company-1");
		user2.setRole(Set.of(Role.ADMIN.toString(), Role.MANAGER.toString()));
		User user3 = new User();
		user3.setCompanyId("company-2");
		user3.setRole(Set.of(Role.MANAGER.toString()));

		userRepository.saveAll(List.of(user1, user2, user3));
	}

	@AfterEach
	void tearDown() {
		userRepository.deleteAll();
	}
	
	@Test
	@DisplayName("findAll should return user list")
	void findAll() {
		// When
		List<User> users = userRepository.findAll(PageRequest.of(0, 20)).getContent();

		// Then
		assertEquals(3, users.size());
	}

	@Test
	@Tag("SkipInit")
	@DisplayName("findByUserId should return user given userId")
	void findByUserId() {
		// Given
		User user = new User();
		user.setUsername("user1");
		String userId = userRepository.save(user).getUserId();

		// When
		Optional<User> savedUser = userRepository.findByUserId(userId);

		// Then
		assertTrue(savedUser.isPresent());
		assertEquals("user1", savedUser.get().getUsername());
	}

	@Test
	@DisplayName("findByCompanyId should return user given companyId")
	void findByCompanyId() {
		// When
		List<User> users = userRepository.findByCompanyId("company-1");

		// Then
		assertEquals(2, users.size());
	}

	@Test
	@DisplayName("findByRole should return user given role")
	void findByRole() {
		// When
		List<User> users = userRepository.findByRole(Role.ADMIN);

		// Then
		assertEquals(2, users.size());
	}
}