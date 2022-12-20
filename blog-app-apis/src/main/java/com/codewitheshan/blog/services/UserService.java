package com.codewitheshan.blog.services;

import java.util.List;

import com.codewitheshan.blog.payloads.UserDto;

// After the entity, repository we will make services 
// userService interface 

public interface UserService {
	
	// method to create user 
	// here we will not pass user directly, User createUser(User user) we'll not do
	// we will make class Dto inside payload package for user 
	UserDto createUser(UserDto user);
	
	// we will use Dto to transfer data from now 
	// method for update
	UserDto updateUser(UserDto user, Integer userId);
	
	
	//method for get 
	UserDto getUserById(Integer userId);
	
	// get all the users in a list 
	List<UserDto> getAllUsers();
	
	// for delete 
	void deleteUser(Integer userId);
}
