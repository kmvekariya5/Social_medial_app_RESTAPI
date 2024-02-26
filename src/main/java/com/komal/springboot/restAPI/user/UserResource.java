package com.komal.springboot.restAPI.user;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDao service;
	
	
	public UserResource(UserDao service) {
		super();
		this.service = service;
	}


	//GET/users
	@GetMapping(value="/users")
	public ArrayList<User> getAllUsers()
	{
		return service.findAll();
	}
	
	@GetMapping(value="/users/{id}")
	public User getUserById(@PathVariable Integer id)
	{
		User user = service.findById(id);
		
		if(user == null)
		{
			throw new UserNotFoundException("id="+id);
		}
		return  user;
	}
	
	@DeleteMapping(value="/users/{id}")
	public void deleteUserById(@PathVariable Integer id)
	{
		service.deleteById(id);
	}
	
	@PostMapping(value="/users")
	public ResponseEntity<Object> insertUser(@Valid @RequestBody User user)
	{
		User data = service.saveUser(user);
		URI location = ServletUriComponentsBuilder.
							fromCurrentRequest().
							path("/{id}").
							buildAndExpand(data.getId()).
							toUri();
		return ResponseEntity.created(location).build();
	}
}
