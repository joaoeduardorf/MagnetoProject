package com.magneto.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magneto.application.dtos.DNARequest;
import com.magneto.application.interfaces.IMutantAppService;
import com.magneto.domain.entities.DNA;
import com.magneto.domain.services.interfaces.IMutantService;

@Service
public class MutantAppService implements IMutantAppService{

	private static IMutantService _mutantService;
	
	@Autowired
	public MutantAppService(IMutantService mutantService) {
		_mutantService = mutantService;
	}
	
	@Override
	public boolean isMutant(DNARequest dnaRequest) throws Exception {
		
		DNA dna = new DNA(dnaRequest.dna);
		
		return _mutantService.isMutant(dna);
	}

}
