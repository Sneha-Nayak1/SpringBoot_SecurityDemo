package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.MyUserService;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	private MyUserService userService;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
//		http.csrf(csrf -> csrf.disable())
//		.authorizeHttpRequests(authorize->authorize.anyRequest().authenticated())
//		.httpBasic();
//		return http.build();
		
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(req -> {
			req.requestMatchers("/home","/register/**").permitAll();
			req.requestMatchers("/admin/**").hasRole("ADMIN");
			req.requestMatchers("/user/**").hasRole("USER");
			req.anyRequest().authenticated();
		})
				.formLogin(formLogin -> formLogin.permitAll())
				.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails sneha=User.builder()
//				.username("sneha")
//				.password(passwordEncoder().encode("sneha"))
//				.roles("USER")
//				.build();
//		
//		UserDetails admin=User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("admin"))
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(sneha,admin);
//	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return userService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	
}
