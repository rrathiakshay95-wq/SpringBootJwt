package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.alien.Alien;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/aliens")
public class AlienController {
	public static List<Alien> aliens = new ArrayList<>(Arrays.asList(new Alien(1, "Akshay", "earth"), new Alien(2, "Vijay", "moon")));

	@GetMapping("/getAll")
	public List<Alien> getAlien() {

		return aliens;

	}

	@PostMapping("/add")
	public Alien addAlient(@RequestBody Alien alien) {
		aliens.add(alien);
		return alien;
	}
	@GetMapping("/getCsrfToken")
	public CsrfToken getCsrf(HttpServletRequest req)
	{
		return (CsrfToken) req.getAttribute("_csrf");
	}
}
