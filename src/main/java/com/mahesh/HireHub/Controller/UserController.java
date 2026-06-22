package com.mahesh.HireHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.HireHub.Entity.User;
import com.mahesh.HireHub.Service.UserService;

//@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {	
		user.setPassword(new BCryptPasswordEncoder(10).encode(user.getPassword()));
		
		if (userService.register(user)) {
			return ResponseEntity.ok("User registered successfully");
		}

		// Bug
		return ResponseEntity
				.badRequest().body("Not Register");
	}

	@GetMapping("/login")
	public String getUserByEmail() {
		return "Loged In";
	}
	
	@GetMapping("/me")
	public Authentication me(Authentication authentication) {
	    return authentication;
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		if (userService.deleteuser(id)) {
			return ResponseEntity.ok("User removed successfully");
		}

		// Bug
		return ResponseEntity
				.badRequest().body("Not Register");

	}

	@PutMapping("/user")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		if (userService.updateUser(user)) {
			return ResponseEntity.ok("Updated successfully");
		}

		// Bug
		return ResponseEntity
				.badRequest().body("Not Register"); 
	}

}
