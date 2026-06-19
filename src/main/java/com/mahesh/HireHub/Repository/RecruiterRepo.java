package com.mahesh.HireHub.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.HireHub.Entity.Recruiter;

public interface RecruiterRepo extends JpaRepository<Recruiter, Integer> {
	
	Optional<Recruiter> findByEmail(String email);
	
	boolean existsByEmail(String email);

}
