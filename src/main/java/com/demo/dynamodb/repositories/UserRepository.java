package com.demo.dynamodb.repositories;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.entities.user.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableScan
@EnableScanCount
public interface UserRepository
		extends CrudRepository<User, String>,
				MyUserRepository {

	Page<User> findAll(Pageable pageable);

	List<User> findByRole(Role role);
}
