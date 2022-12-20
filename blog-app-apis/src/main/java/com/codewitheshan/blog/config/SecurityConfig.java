//package com.codewitheshan.blog.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
////import com.codewitheshan.blog.security.CustomUserDetailService;
////import com.codewitheshan.blog.security.JwtAuthenticationEntryPoint;
////import com.codewitheshan.blog.security.JwtAuthenticationFilter;
//
//// we are using new version 
//// we can configure without override
//@Configuration
//public class SecurityConfig {
//	
////	@Autowired
////	private CustomUserDetailService customUserDetailService;
//	
////	@Autowired
////	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	
////	@Autowired
////	private JwtAuthenticationFilter jwtAuthenticationFilter;
//	
//	// we can declare a bean for security filter chain 
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//		.csrf()
//		.disable()
//		.authorizeHttpRequests()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic();
//
////		http
////		.csrf()
////		.disable()
////		.authorizeHttpRequests()
////		.anyRequest()
////		.authenticated()
////		.and()
////		.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
////		.and()
////		.sessionManagement()
////		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
////		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//		
//		return http.build();
//    }
//     
////    @Bean
////    public WebSecurityCustomizer webSecurityCustomizer() {
////         
////    }
//
////	@Bean
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////		
////		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
////	}
//	
////	@Bean
////	public PasswordEncoder passwordEncoder() {
////		return new BCryptPasswordEncoder();
////	}
//	
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception{
//		return this.authenticationManagerBean();
//	}
//	
////	@Bean
////	public interface AuthenticationManager {
////
////		  Authentication authenticate(Authentication authentication)
////		    throws AuthenticationException;
////		}
//	
//}
