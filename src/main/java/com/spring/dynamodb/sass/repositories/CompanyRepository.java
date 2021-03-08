package com.spring.dynamodb.sass.repositories;

import com.spring.dynamodb.sass.entities.Company.Company;
import com.spring.dynamodb.sass.entities.User.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface CompanyRepository extends CrudRepository<Company, String> {

	List<Company> findAll();
}
