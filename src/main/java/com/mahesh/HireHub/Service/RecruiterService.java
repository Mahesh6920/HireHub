package com.mahesh.HireHub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.HireHub.Entity.Recruiter;
import com.mahesh.HireHub.Repository.RecruiterRepo;

@Service
public class RecruiterService {
	
	@Autowired
	private RecruiterRepo repo;

	
	public boolean register(Recruiter recruiter) {
		if (repo.existsByEmail(recruiter.getEmail())) {
			return false;
		}
		
		repo.save(recruiter);
		
		return true;
	}

}
