package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityController {
	@GetMapping("/hello")
	public String hello(HttpServletRequest req)
	{
		
		return req.getSession().getId();
	}
	@GetMapping("/about")
	public String about(HttpServletRequest req)
	{
		
		return req.getSession().getId();
	}
}
