package com.demo.dynamodb.mappers;

import com.demo.dynamodb.dtos.company.CompanyGetDto;
import com.demo.dynamodb.entities.Company.Company;
import com.demo.dynamodb.dtos.company.CompanyPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

	Company toEntity(CompanyPostDto companyPostDto);

	CompanyGetDto fromEntity(Company company);

	void copy(CompanyPostDto companyPutDto, @MappingTarget Company company);
}
