package com.ear.core.config;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ear.core.model.AuthenticatedModel;
import com.ear.core.model.AuthorizedModel;
import com.ear.core.model.UserModel;
import com.ear.core.service.AuthenticatedService;
import com.ear.core.service.AuthorizedService;
import com.ear.core.service.UserService;

@Component
public class SecurityPwdAuthProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorizedService authorizedService;
	
	@Autowired
	private AuthenticatedService authenticatedService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) {
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		UserModel userModel = this.userService.getUserByEmail(username);

		if (userModel == null) {
			throw new BadCredentialsException("No user registered with this details!");	
		}
			
		Integer idUser = userModel.getId();
										
		List<AuthenticatedModel> listAuthenticated = this.authenticatedService.getListAuthenticatedByUuidUser(idUser);
		List<AuthorizedModel> listAuthorized 	   = this.authorizedService.getListAuthorizedByUuidUser(idUser);

		userModel.setListAuthenticated(listAuthenticated);
		userModel.setListAuthorized(listAuthorized);
		
		if (this.passwordEncoder.matches(password, userModel.getPassword())) {
			
			return new UsernamePasswordAuthenticationToken(username, password, this.getGrantedAuthorities(userModel));
			
		} else { 
			
			throw new BadCredentialsException("Invalid password!");
			
		}
								
		
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(UserModel userModel) {		
		List<AuthenticatedModel> listAuthenticated = userModel.getListAuthenticated();
		List<AuthorizedModel> lisAuthorized = userModel.getListAuthorized();		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();		
        for (AuthenticatedModel authority : listAuthenticated) {        	
        	grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        	
        }        
        for (AuthorizedModel authority : lisAuthorized) {        	
        	grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));        
        }        
        return grantedAuthorities;       
    }

	@Override
	public boolean supports(Class<?> authenticationType) {
		return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
