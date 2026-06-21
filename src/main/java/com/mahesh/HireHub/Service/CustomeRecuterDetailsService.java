package com.mahesh.HireHub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mahesh.HireHub.Entity.Recruiter;
import com.mahesh.HireHub.Repository.RecruiterRepo;

@Service
public class CustomeRecuterDetailsService implements UserDetailsService {
	
	@Autowired
	private RecruiterRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Recruiter recuiter = repo.findByEmail(username)
	            .orElseThrow(() ->
                new UsernameNotFoundException("User Not Found"));
		
		return User
				.builder()
				.username(recuiter.getEmail())
		        .password(recuiter.getPassword())
		        .roles("RECRUITER")
		        .build();
	}

}
