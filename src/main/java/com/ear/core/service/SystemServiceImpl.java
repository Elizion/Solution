package com.ear.core.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.repository.SystemRepository;

@Service
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private SystemRepository systemRepository;

	@Override
	public Date getDateSystem() {
		return this.systemRepository.getDateSystem();
	}
	
	@Override
	public Integer getIdUser() {
		return this.systemRepository.getIdUser();
	}
	
}
