package com.ear.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {

	private static final long serialVersionUID = -6690946490872875352L;

	private final UserModel userModel;

	public SecurityUser(UserModel userModel) {
		this.userModel = userModel;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		List<GrantedAuthority> authorities = new ArrayList<>();		
		for(AuthenticatedModel item: userModel.getListAuthenticated()) {
			authorities.add(new SimpleGrantedAuthority(item.getName()));
		}		
		for(AuthorizedModel item: userModel.getListAuthorized()) {
			authorities.add(new SimpleGrantedAuthority(item.getName()));
		}		
		return authorities;		
	}

	@Override
	public String getPassword() {
		return userModel.getPassword();
	}

	@Override
	public String getUsername() {
		return userModel.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
