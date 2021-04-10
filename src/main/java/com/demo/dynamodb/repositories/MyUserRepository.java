package com.demo.dynamodb.repositories;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.entities.user.User;

import java.util.List;

public interface MyUserRepository {

	List<User> findByRole(Role role);

	List<User> findByCompanyId(String companyId);
}
