package com.magneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> Mutant(@RequestBody DNARequest dna) {
		try {
			boolean result = _mutantAppService.isMutant(dna);
			if(result) {
				return new ResponseEntity<String>(Boolean.toString(result), HttpStatus.OK);	
			}else {
				return new ResponseEntity<String>(Boolean.toString(result), HttpStatus.FORBIDDEN);		
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		
		
	}
}
