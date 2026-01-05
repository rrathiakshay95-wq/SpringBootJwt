package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.alien.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
