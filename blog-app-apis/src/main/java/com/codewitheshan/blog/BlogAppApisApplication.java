package com.codewitheshan.blog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;

// SpringBootApplication is an annotation that signifies
// the start for your application
@SpringBootApplication
public class BlogAppApisApplication{
//public class BlogAppApisApplication implements CommandLineRunner{
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;	// inject password encoder 

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	
	// automatic creating of object where we autowire this 
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(this.passwordEncoder.encode("xyz"));
//		
//	}

}
