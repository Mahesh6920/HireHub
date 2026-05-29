package com.mahesh.HireHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.HireHub.Entity.User;
import com.mahesh.HireHub.Service.UserService;

@CrossOrigin(origins = "http://localhost:5173/")
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
		if (userService.register(user)) {
			return ResponseEntity.ok("User registered successfully");
		}

		// Bug
		return ResponseEntity
				.badRequest().body("Not Register");
	}

	@GetMapping("/user")
	public User getUserByEmail(@RequestParam String email) {
		return userService.getUserByEmail(email);
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

}
