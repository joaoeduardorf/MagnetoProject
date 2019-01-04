package com.magneto.domain.services.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magneto.domain.entities.DNA;
import com.magneto.domain.repositories.interfaces.IMutantRepository;
import com.magneto.domain.services.interfaces.IMutantService;

@Service
public class MutantService implements IMutantService {

	private IMutantRepository _mutantRepository;

	@Autowired
	public MutantService(IMutantRepository mutantRepository) {
		_mutantRepository = mutantRepository;
	}

	@Override
	public boolean isMutant(DNA dna) throws Exception {
		if (!dna.isMatrixNN()) {
			throw new Exception("Invalid matrix");
		}

		if (!dna.isValidNucleotide()) {
			throw new Exception("Invalid sequence of nucleotides");
		}

		if (dna.isMatrixNN() && dna.isValidNucleotide()) {
			dna.setId(ObjectId.get());
			dna.isMutant();
			_mutantRepository.save(dna);
		}
		return dna.isMutant();
	}

}
