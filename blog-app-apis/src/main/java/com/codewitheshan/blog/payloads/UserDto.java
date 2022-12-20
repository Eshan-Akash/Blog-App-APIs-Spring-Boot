package com.codewitheshan.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter		// when we use them at the field level, lombok generate getters and setters only for the decorated fiels
@Setter
public class UserDto {  // "UserDto" class we'll use to transfer data
	// id, name, email, password, about 
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Username maust be min of 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid")
	private String email;
	
	// you can use regex 
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars!!")
	private String password;
	
	@NotEmpty
	private String about;
	
}
