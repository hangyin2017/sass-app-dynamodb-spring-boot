package com.spring.dynamodb.sass.mappers;

import com.spring.dynamodb.sass.dtos.user.UserGetDto;
import com.spring.dynamodb.sass.dtos.user.UserPostDto;
import com.spring.dynamodb.sass.entities.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	User toEntity(UserPostDto userPostDto);

	UserGetDto fromEntity(User user);

	void copy(UserPostDto userPutDto, @MappingTarget User user);
}
