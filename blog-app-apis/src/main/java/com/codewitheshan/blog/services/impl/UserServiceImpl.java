package com.codewitheshan.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.codewitheshan.blog.exceptions.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewitheshan.blog.payloads.UserDto;
import com.codewitheshan.blog.services.UserService;
import com.codewitheshan.blog.repositories.*;
import com.codewitheshan.blog.entities.*;

@Service
public class UserServiceImpl implements UserService {
	
	// We want a repository to crate, update, get 
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// convert dto to user and store in user object 
		User user = this.dtoToUser(userDto);
		// save user in userRepo 
		User savedUser = this.userRepo.save(user);
		// convert into dto and return 
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// find userId in userRepo and store it in user 
		// create ResourceNotFoundException for handling exception 
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		// user is save in userRepo it will give an output 
		User updatedUser = this.userRepo.save(user);  
		// converting user into Dto
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// find userId in userRepo and store it in user 
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		
		// convert user in UserDto and return 
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// from userRepo find all and store it into list of User data type
		// users is the List name 
		List<User> users = this.userRepo.findAll();
		// stream - not a data structure instead it takes i/p from a collection, array or i/o channel
		// it only provide the result as per the pipeline methods 
		// intermediate operations : map, filter, sorted
		// terminal operations : collect, forEach, reduce
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// get/find the user from userRepo 
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		// delete the user from userRepo 
		this.userRepo.delete(user);
	}
	
	// method to convert dto(data transfer object) to entity
	private User dtoToUser(UserDto userDto) {
		// object of User class 
		User user = this.modelMapper.map(userDto,  User.class);
		
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}
	 
	// Dto = data tansfer object 
	// method to convert entity to dto 
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
