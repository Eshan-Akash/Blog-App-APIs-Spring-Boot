package com.codewitheshan.blog.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor		// will generate a constructor with no parameters
@Getter	// you can annotate any field with @getter & @setter, to let lombok generate the default getter/setter automatically 
@Setter
public class User{
//public class User implements UserDetails{
	// we need id, name, email, password, about
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //making id as primary key, make it auto increment 
	private int id;
	
	@Column(name="user_name", nullable = false, length = 100) // if you want to change the name of the column
	private String name;
	// We can do the same with email, password and about
	private String email;
	
	private String password;
	
	private String about;
	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Post> posts = new ArrayList<>();
//	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "user_role",
//	joinColumns = @JoinColumn(name="user", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "id")
//			)
//	private Set<Role> rolees = new HashSet<>();

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// we will take each role and change it into granted authority 
//		List<SimpleGrantedAuthority> authorities = this.rolees.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//		return authorities;
//	}

//	@Override
//	public String getUsername() {
//		return this.email;	// make it true 
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;	// make it true
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;	// make it true
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;	// make it true
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true; // make it true 
//	}
	
}
