package com.demo.dynamodb.controllers;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.dtos.user.UserGetDto;
import com.demo.dynamodb.dtos.user.UserPostDto;
import com.demo.dynamodb.services.UserService;
import com.demo.dynamodb.utils.TestHelper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TestHelper testHelper;

	@MockBean
	private UserService userService;

	@Test
	@DisplayName("list should return user list")
	void listTest() throws Exception {
		// Given
		UserGetDto userGetDto1 = new UserGetDto();
		userGetDto1.setUserId("user-1");
		UserGetDto userGetDto2 = new UserGetDto();
		userGetDto2.setUserId("user-2");

		given(userService.list(PageRequest.of(0, 20))).willReturn(List.of(userGetDto1, userGetDto2));

		// When
		mockMvc.perform(get("/api/v1/users"))

				// Then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}

	@Test
	@DisplayName("addOne should add user given post dto")
	void addOneTest() throws Exception {
		// Given
		UserPostDto userPostDto = new UserPostDto("username-1", "user1@demo.com", Set.of(Role.MANAGER), "company-1");

		UserGetDto userGetDto = new UserGetDto();
		userGetDto.setUserId("user-1");

		given(userService.addOne(userPostDto)).willReturn(userGetDto);

		// When
		mockMvc.perform(post("/api/v1/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(testHelper.asJsonString(userPostDto)))

				// Then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.userId", is("user-1")));
	}

	@Test
	@DisplayName("findByCompanyId should return user list given companyId")
	void findByCompanyId() throws Exception {
		// Given
		String companyId = "company-1";
		UserGetDto userGetDto1 = new UserGetDto();
		userGetDto1.setUserId("user-1");
		UserGetDto userGetDto2 = new UserGetDto();
		userGetDto2.setUserId("user-2");

		given(userService.findByCompanyId(companyId)).willReturn(List.of(userGetDto1, userGetDto2));

		// When
		mockMvc.perform(get("/api/v1/users/company")
				.param("companyId", companyId))

				// Then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}
}