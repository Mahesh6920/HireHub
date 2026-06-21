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


	public boolean updateRecruiter(Recruiter recruiter) {
		if (repo.save(recruiter) != null) {
			return true;
		}
		
		return false;
	}


	public boolean deleteRecruiter(int id) {
		if (!repo.existsById(id)) {
			return false;
		}
		
		repo.deleteById(id);
		return true;
	}


}
