package com.mahesh.HireHub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/login")
	public String getRecruiterByEmail() {
		return "Loged In";
	}
	
	@GetMapping("/me")
	public Authentication me(Authentication authentication) {
	    return authentication;
	}
	
	@PutMapping("/user")
	public ResponseEntity<String> updateRecruiter(@RequestBody Recruiter recruiter) {
		if (service.updateRecruiter(recruiter)) {
			return ResponseEntity.ok("Updated Successful");
		}
		
		return ResponseEntity.badRequest().body("Updation Failed");
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteRecruiter(@PathVariable int id) {
		if (service.deleteRecruiter(id)) {
			return ResponseEntity.ok("Recruiter Deleted");
		}
		
		return ResponseEntity.badRequest().body("Recruiter Deletion Failed");
	}
	
}
