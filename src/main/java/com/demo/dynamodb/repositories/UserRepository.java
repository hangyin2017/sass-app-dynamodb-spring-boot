package com.demo.dynamodb.repositories;

import com.demo.dynamodb.entities.user.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableScan
public interface UserRepository extends CrudRepository<User, String> {

	List<User> findAll();
}
