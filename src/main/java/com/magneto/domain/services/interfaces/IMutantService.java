package com.magneto.domain.services.interfaces;

import com.magneto.domain.entities.DNA;
import com.magneto.domain.entities.Stats;

public interface IMutantService {
	boolean isMutant(DNA dna) throws Exception;
	Stats stats();
}
