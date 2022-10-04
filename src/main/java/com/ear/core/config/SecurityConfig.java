package com.ear.core.config;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.ear.core.filter.AuthoritiesLoggingAfterFilter;
import com.ear.core.filter.AuthoritiesLoggingAtFilter;
import com.ear.core.filter.JWTTokenGeneratorFilter;
import com.ear.core.filter.JWTTokenValidatorFilter;
import com.ear.core.filter.RequestValidationBeforeFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()		
		.cors()
		.configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				
				CorsConfiguration config = new CorsConfiguration();
				
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setExposedHeaders(Arrays.asList("Authorization"));
				config.setMaxAge(3600L);
				
				return config;
				
			}
			
		})
		.and()
		.csrf().disable()
		.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
		.addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
		.authorizeRequests()
        .antMatchers(
                "/favicon.ico",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.svg",
                "/**/*.jpg",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/**/*.ts").permitAll()			
			.antMatchers("/api/session/**").authenticated()
        	.antMatchers("/api/user/created").hasRole("ADMIN")
        	.antMatchers("/api/user/get").hasAnyRole("ADMIN","USER")
        	.antMatchers("/api/user/get/actives").hasAnyRole("ADMIN","USER")
        	.antMatchers("api/activity/**").hasAnyRole("ADMIN","USER")        	
			.antMatchers("/api/store/**").permitAll()
			.antMatchers("/api/material/**").permitAll()
			.antMatchers("/api/price/**").permitAll()
			.antMatchers("/api/historical/**").permitAll()
			.antMatchers("/api/ticket/**").permitAll()
			.antMatchers("/api/system/**").permitAll()
			.antMatchers("/api/test/**").permitAll().and().httpBasic();
		
	}

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
