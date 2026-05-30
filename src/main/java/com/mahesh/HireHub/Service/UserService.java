package com.mahesh.HireHub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.HireHub.Entity.User;
import com.mahesh.HireHub.Repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public boolean register(User user) {

		if (userRepo.existsByEmail(user.getEmail())) {
			return false;
		}

		userRepo.save(user);

		return true;
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User Not Found."));
	}

	public boolean deleteuser(int id) {
		if (!userRepo.existsById(id)) {
			return false;
		}

		userRepo.deleteById(id);
		return true;
	}

	public boolean updateUser(User user) {
		if (userRepo.save(user) != null) {
			return true;
		}
		return false;
	}




}
