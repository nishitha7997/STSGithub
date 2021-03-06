package com.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cb.model.User;
import com.cb.repo.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String saveUser(@RequestBody User user)
	{
		userRepo.save(user);
		return "user saved successfully";
	} 
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}

}
