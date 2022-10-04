package com.ear.core;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@ComponentScans({ 
	@ComponentScan("com.ear.core.controller"), 
	@ComponentScan("com.ear.core.config")
})
@EntityScan("com.ear.core.model")
@EnableWebSecurity(debug = false)
public class SolutionApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
	}

}
