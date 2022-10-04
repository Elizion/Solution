package com.ear.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ear.core.model.SecurityUser;
import com.ear.core.model.UserModel;
import com.ear.core.repository.UserRepository;

@Service
public class SecurityUserDetails implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepository.getUserByEmail(username);
		if (user == null) throw new UsernameNotFoundException("User details not found for the user!" + username);			
		return new SecurityUser(user); 
	}
	
}
