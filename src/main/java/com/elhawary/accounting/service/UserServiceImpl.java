package com.elhawary.accounting.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elhawary.accounting.model.User;
import com.elhawary.accounting.repository.UserRepository;
import com.elhawary.accounting.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository ;

	@Override
	public User save(User user) {
		String password = PasswordUtil.GetPasswordHah(user.getPassword()) ;
		user.setPassword(password);
		user.setCreatedDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return  (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmailIgnoreCase(email);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		user.setUpdatedDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
}
