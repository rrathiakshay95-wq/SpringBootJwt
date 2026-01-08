package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.alien.User;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	
	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return userService.save(user);
	}
	@PostMapping("/login")
	public String login(@RequestBody User user)
	{
		Authentication authentication=authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated())
		{
			return jwtService.generateToken(user.getUsername());
		}
		else {
			return "fails";
		}
		
	}
}
