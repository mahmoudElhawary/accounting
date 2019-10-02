package com.elhawary.accounting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.accounting.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmailIgnoreCase(String username);
}
