package com.spring.dynamodb.sass.mappers;

import com.spring.dynamodb.sass.dtos.company.CompanyGetDto;
import com.spring.dynamodb.sass.dtos.company.CompanyPostDto;
import com.spring.dynamodb.sass.entities.Company.Company;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

	Company toEntity(CompanyPostDto companyPostDto);

	CompanyGetDto fromEntity(Company company);

	void copy(CompanyPostDto companyPutDto, @MappingTarget Company company);
}
