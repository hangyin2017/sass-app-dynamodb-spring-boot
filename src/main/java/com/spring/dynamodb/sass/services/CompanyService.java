package com.spring.dynamodb.sass.services;

import com.spring.dynamodb.sass.dtos.company.CompanyGetDto;
import com.spring.dynamodb.sass.dtos.company.CompanyPostDto;
import com.spring.dynamodb.sass.dtos.user.UserGetDto;
import com.spring.dynamodb.sass.dtos.user.UserPostDto;
import com.spring.dynamodb.sass.entities.Company.Company;
import com.spring.dynamodb.sass.entities.User.User;
import com.spring.dynamodb.sass.mappers.CompanyMapper;
import com.spring.dynamodb.sass.mappers.UserMapper;
import com.spring.dynamodb.sass.repositories.CompanyRepository;
import com.spring.dynamodb.sass.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyRepository companyRepository;

	private final CompanyMapper companyMapper;

	public List<CompanyGetDto> getAll() {
		List<Company> companys = companyRepository.findAll();
		List<CompanyGetDto> companyGetDtos = companys.stream()
				.map(companyMapper::fromEntity)
				.collect(Collectors.toList());
		return companyGetDtos;
	}

	public CompanyGetDto addOne(CompanyPostDto companyPostDto) {
		Company company = companyMapper.toEntity(companyPostDto);
		Company savedCompany = companyRepository.save(company);
		return companyMapper.fromEntity(savedCompany);
	}
}
