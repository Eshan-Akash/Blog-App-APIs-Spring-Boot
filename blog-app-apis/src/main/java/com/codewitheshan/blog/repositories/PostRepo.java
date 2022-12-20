package com.codewitheshan.blog.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codewitheshan.blog.entities.Category;
import com.codewitheshan.blog.entities.Post;
import com.codewitheshan.blog.entities.User;
import com.codewitheshan.blog.payloads.PostDto;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	// findByName -> this way we write custom finder method in repository 
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	// for manual query
//	@Query("select p from Post p where p.title like :key")
//	List<Post> searchByTitle(@Param("key") String title);
}
