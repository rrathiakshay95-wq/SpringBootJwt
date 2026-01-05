package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	UserDetailsService userDetailsService;
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http)
	{
		http.csrf(csrfCustomizer -> csrfCustomizer.disable());
		http.formLogin(customizer -> customizer.disable());
		http.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}

    @SuppressWarnings("deprecation")
	@Bean
    AuthenticationProvider addProvider()
	{
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider(userDetailsService);
		authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		return authenticationProvider;
	}	

}
