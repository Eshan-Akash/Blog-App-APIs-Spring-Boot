 package com.codewitheshan.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewitheshan.blog.entities.User;

// After the entity is ready, now we want repository to put/fetch data from database 
// we will make an interface and extends from JpaRepository <which entity, id type>
// should not annotate with @service 
public interface UserRepo extends JpaRepository<User, Integer>{
	// we are creating email as a user 
//	Optional<User> findByEmail(String email);
	
}
