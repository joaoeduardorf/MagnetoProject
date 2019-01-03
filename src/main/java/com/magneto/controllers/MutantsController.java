package com.magneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.application.dtos.DNARequest;
import com.magneto.application.interfaces.IMutantAppService;

@RestController
public class MutantsController {
	
	private static IMutantAppService _mutantAppService;
	
	@Autowired
	public MutantsController(IMutantAppService mutantAppService) {
		_mutantAppService = mutantAppService;
	}
	
	@PostMapping(path="/mutant")
	public boolean Mutant(@RequestBody DNARequest dna) {
		return _mutantAppService.isMutant(dna);		
	}
}
