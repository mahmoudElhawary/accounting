package com.elhawary.accounting.service;

import java.util.List;

import com.elhawary.accounting.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	Iterable<User> getUsers() ;
	
	User getUserByEmail(String email);

	User getUser(Long id);

	User updateUser(User userDB);

	User findOne(Long id);

}
