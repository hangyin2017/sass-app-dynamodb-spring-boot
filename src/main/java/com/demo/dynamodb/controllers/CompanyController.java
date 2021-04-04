package com.demo.dynamodb.controllers;

import com.demo.dynamodb.dtos.company.CompanyGetDto;
import com.demo.dynamodb.dtos.company.CompanyPostDto;
import com.demo.dynamodb.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

	private final CompanyService companyService;

	@GetMapping
	public List<CompanyGetDto> list() {
		List<CompanyGetDto> companyList = companyService.list();
		return companyList;
	}

	@PostMapping
	public CompanyGetDto addOne(@RequestBody @Valid CompanyPostDto companyPostDto) {
		CompanyGetDto savedCompany = companyService.addOne(companyPostDto);
		return savedCompany;
	}
}
