package com.demo.dynamodb.mappers;

import com.demo.dynamodb.dtos.user.UserGetDto;
import com.demo.dynamodb.dtos.user.UserPostDto;
import com.demo.dynamodb.entities.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	User toEntity(UserPostDto userPostDto);

	UserGetDto fromEntity(User user);

	void copy(UserPostDto userPutDto, @MappingTarget User user);
}
