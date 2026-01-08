package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtFilter jwtFilter;
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http)
	{
		http.csrf(csrfCustomizer -> csrfCustomizer.disable());
		http.formLogin(customizer -> customizer.disable());
		
		http.authorizeHttpRequests(customizer -> customizer
				.requestMatchers("/register","/login").permitAll()
				.anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

	
	
    @SuppressWarnings("deprecation")
	@Bean
    AuthenticationProvider addProvider()
	{

    	DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider(userDetailsService);
		

    	
    	authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		
		return authenticationProvider;
	}

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config)
    {
    	return config.getAuthenticationManager();
    }

}
