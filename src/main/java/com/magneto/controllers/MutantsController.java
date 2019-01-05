package com.magneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.application.dtos.DNARequest;
import com.magneto.application.interfaces.IMutantAppService;
import com.magneto.domain.entities.Stats;

@RestController
public class MutantsController {

	private static IMutantAppService _mutantAppService;

	@Autowired
	public MutantsController(IMutantAppService mutantAppService) {
		_mutantAppService = mutantAppService;
	}

	@PostMapping(path = "/mutant")
	public ResponseEntity<String> Mutant(@RequestBody DNARequest dna) {
		try {
			boolean isMutant = _mutantAppService.isMutant(dna);

			return new ResponseEntity<String>(Boolean.toString(isMutant), isMutant ? HttpStatus.OK : HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path = "/stats")
	public ResponseEntity<Stats> Stats() {
		Stats stats = _mutantAppService.stats();
		
		return new ResponseEntity<Stats>(stats, HttpStatus.OK);
	}
}
