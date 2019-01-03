package com.magneto.domain.services.impl;

import org.springframework.stereotype.Service;

import com.magneto.domain.entities.DNA;
import com.magneto.domain.services.interfaces.IMutantService;

@Service
public class MutantService implements IMutantService{

	@Override
	public boolean isMutant(DNA dna) {
		if(!dna.isMatrixNN()) {
			
		}
		
		if(!dna.isValidNucleotide()) {
			try {
				throw new Exception("Invalid sequence of nucleotides");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(!dna.isMatrixNN()&& dna.isValidNucleotide()) {
			
		}
		return false;
	}

}
