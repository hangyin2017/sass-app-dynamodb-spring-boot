package com.spring.dynamodb.sass.controllers;

import com.spring.dynamodb.sass.dtos.company.CompanyGetDto;
import com.spring.dynamodb.sass.dtos.company.CompanyPostDto;
import com.spring.dynamodb.sass.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<CompanyGetDto>> getAll() {
		List<CompanyGetDto> companys = companyService.getAll();
		return ResponseEntity.ok(companys);
	}

	@PostMapping
	public ResponseEntity<CompanyGetDto> addOne(@RequestBody CompanyPostDto companyPostDto) {
		CompanyGetDto savedCompany = companyService.addOne(companyPostDto);
		return ResponseEntity.ok(savedCompany);
	}
}
