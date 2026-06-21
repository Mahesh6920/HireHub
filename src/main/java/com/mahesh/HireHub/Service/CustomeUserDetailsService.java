package com.mahesh.HireHub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mahesh.HireHub.Entity.User;
import com.mahesh.HireHub.Repository.UserRepository;

@Service
public class CustomeUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Login Attempt: " + username);

	    User user = repo.findByEmail(username)
	            .orElseThrow(() ->
	                    new UsernameNotFoundException("User Not Found"));

	    System.out.println("User Found: " + user.getEmail());
		
		return org.springframework.security.core.userdetails.User
				.builder()
				.username(user.getEmail())
		        .password(user.getPassword())
		        .roles("USER")
		        .build();
	}	

}


