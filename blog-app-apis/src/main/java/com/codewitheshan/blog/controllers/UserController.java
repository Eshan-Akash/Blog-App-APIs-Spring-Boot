package com.codewitheshan.blog.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewitheshan.blog.payloads.ApiResponse;
import com.codewitheshan.blog.payloads.UserDto;
import com.codewitheshan.blog.services.UserService;

import jakarta.validation.Valid;
// make APIs and use mapping 
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	Spring Web applications and services need to process client requests sent 
//	over HTTP. When the HTTP clients send data with the request, the data is 
//	in the request body. On the application side, you need a mechanism to 
//	deserialize data sent in the request body to domain objects. This is done 
//	using the @RequestBody annotation.
	
	// POST-create user     // returns UserDto when createUser is called       
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		// create user from userDto object 
		UserDto createUserDto = this.userService.createUser(userDto);
		// we will return the usercreated , and the status as created
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	// PUT - update user
	@PutMapping("/{userId}")  // {usetID} -> path URI variable 
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	// DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}
	
//	we use the @PathVariable annotation to extract the templated part of the URI,
//	represented by the variable {id}.
	// GET - user get 
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
}
