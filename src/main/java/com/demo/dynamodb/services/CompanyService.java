package com.demo.dynamodb.services;

import com.demo.dynamodb.dtos.company.CompanyGetDto;
import com.demo.dynamodb.dtos.company.CompanyPostDto;
import com.demo.dynamodb.entities.company.Company;
import com.demo.dynamodb.mappers.CompanyMapper;
import com.demo.dynamodb.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyRepository companyRepository;

	private final CompanyMapper companyMapper;

	public List<CompanyGetDto> list() {
		List<Company> companys = companyRepository.findAll();
		List<CompanyGetDto> companyGetDtos = companys.stream()
				.map(companyMapper::fromEntity)
				.collect(Collectors.toList());
		return companyGetDtos;
	}

	public CompanyGetDto addOne(CompanyPostDto companyPostDto) {
		Company company = companyMapper.toEntity(companyPostDto);
		Date now = new Date();
		company.setCreatedAt(now);
		//company.setUpdatedAt(now);
		Company savedCompany = companyRepository.save(company);
		return companyMapper.fromEntity(savedCompany);
	}
}
