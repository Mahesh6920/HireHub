package com.mahesh.HireHub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.HireHub.Entity.Recruiter;
import com.mahesh.HireHub.Service.RecruiterService;

@RestController
@RequestMapping("api/recruiter")
public class RecruiterController {
	
	@Autowired
	private RecruiterService service;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Recruiter recruiter) {
		
		if (service.register(recruiter)) {
			return ResponseEntity.ok().body("Recruiter registered successfully");
		}
		
		return ResponseEntity.badRequest().body("Registration failed");
	}
	
}
