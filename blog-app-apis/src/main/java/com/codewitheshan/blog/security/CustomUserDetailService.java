package com.codewitheshan.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewitheshan.blog.entities.User;
import com.codewitheshan.blog.exceptions.ResourceNotFoundException;
import com.codewitheshan.blog.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	// we need userRepo to get user that is email 
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// loading user from database by username
		User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User ", "email: "+ username, 0));
		
		return user;
	}
	
	
	
}
