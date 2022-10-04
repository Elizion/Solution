package com.ear.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.repository.ChainRepository;

@Service
public class ChainServiceImpl implements ChainService {

	@Autowired
	private ChainRepository chainRepository;

	@Override
	public Integer getIdChain(String nameChain) {
		return this.chainRepository.getIdChain(nameChain);
	}
	
}
