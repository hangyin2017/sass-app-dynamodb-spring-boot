package com.demo.dynamodb.controllers;

import com.demo.dynamodb.dtos.company.CompanyGetDto;
import com.demo.dynamodb.services.CompanyService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
class CompanyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;

	@Test
	@DisplayName("list should return company given token")
	void listTest() throws Exception {
		// Given
		CompanyGetDto companyGetDto1 = new CompanyGetDto();
		companyGetDto1.setCompanyId("company-1");
		CompanyGetDto companyGetDto2 = new CompanyGetDto();
		companyGetDto2.setCompanyId("company-2");

		given(companyService.list()).willReturn(List.of(companyGetDto1, companyGetDto2));

		// When
		mockMvc.perform(get("/api/v1/companies"))

				// Then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}
}