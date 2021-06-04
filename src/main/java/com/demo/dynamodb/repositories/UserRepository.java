package com.demo.dynamodb.repositories;

import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.entities.user.User;
import com.demo.dynamodb.entities.user.UserCompositeKey;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableScan
@EnableScanCount
public interface UserRepository
		extends PagingAndSortingRepository<User, UserCompositeKey>,
				MyUserRepository {

	Page<User> findAll(Pageable pageable);

	Optional<User> findByUserId(String userId);

	List<User> findByRole(Role role);
}
