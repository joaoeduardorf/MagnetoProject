package com.magneto.domain.services.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.magneto.domain.entities.DNA;
import com.magneto.domain.entities.Stats;
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
		boolean result = false;
		if (!dna.isMatrixNN()) {
			throw new Exception("Invalid matrix N*N");
		}

		if (!dna.isValidNucleotide()) {
			throw new Exception("Invalid sequence of nucleotides");
		}

		if (dna.isMatrixNN() && dna.isValidNucleotide()) {
			dna.setId(ObjectId.get());
			result = dna.isMutant();
			_mutantRepository.save(dna);
		}
		return result;
	}

	@Override
	public Stats stats() {
		long mutants = _mutantRepository.countMutant();
		long humans = _mutantRepository.countHuman();
		Stats stats = new Stats(mutants, humans);
		return stats;
	}

}
