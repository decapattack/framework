package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService  extends BaseService<User, Long> {
	
	 @Autowired
	 private UserRepository userRepository;

	@Override
	protected JpaRepository<User, Long> getRepository() {
		// TODO Auto-generated method stub
		return userRepository;
	}

}
