package com.zodiacagefiesta.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zodiacagefiesta.entities.CustomUserDetails;
import com.zodiacagefiesta.entities.User;
import com.zodiacagefiesta.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	private UserRepository userRepo;
	
	UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findAllByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User does not exist. Please check information entered.");
		} 
		
		return new CustomUserDetails(user);
	}
	
	public boolean createUser(User user) {
		boolean created = false;
		
		String checkUsername = user.getUsername();
		
		if (userRepo.findAllByUsername(checkUsername) == null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			
			user.setPassword(encodedPassword);
			
			user.setRole("USER");
			
			userRepo.save(user);
			
			
		} else {
			created = false;
		}
		
		
		return created;
	}
}
