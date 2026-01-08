package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.alien.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public User save(User user) {
		// TODO Auto-generated method stub
		
		return userRepo.save(user);
	}
}
