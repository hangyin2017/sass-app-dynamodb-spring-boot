package com.demo.dynamodb.repositories;

import com.demo.dynamodb.entities.company.Company;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableScan
public interface CompanyRepository
		extends CrudRepository<Company, String>,
				MyCompanyRepository {

	List<Company> findAll();
}
