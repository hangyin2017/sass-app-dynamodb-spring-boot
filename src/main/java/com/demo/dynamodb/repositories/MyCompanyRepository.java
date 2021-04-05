package com.demo.dynamodb.repositories;

import com.demo.dynamodb.entities.user.User;

import java.util.List;

public interface MyCompanyRepository {

	List<User> findUserByCompany(String companyId);
}
