package com.in28mins.springboot.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.springboot.user.User;
import com.in28mins.springboot.user.UserService;

@RestController
public class UserController {

	@Autowired
	public UserService service;

	//Get all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.getUsers();
	}	

	//Get one user
	@GetMapping("/users/{id}")
	public User retrieveOneUser(@PathVariable int id) {
		return service.getUser(id);
	}

	//ADD NEW USER
	@GetMapping("/users/add") 
	public User createUser(){
		return service.createUser();
	}


	/*
	 * //Post a new user
	 * 
	 * @PostMapping("/users") public User createUser(@RequestBody User user){
	 * service.createUser(user); return user; }
	 */

}
