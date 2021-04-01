package com.demo.dynamodb.repositories;

import com.demo.dynamodb.entities.Company.Company;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface CompanyRepository extends CrudRepository<Company, String> {

	List<Company> findAll();
}
