package com.magneto.application.interfaces;

import com.magneto.application.dtos.DNARequest;
import com.magneto.domain.entities.Stats;

public interface IMutantAppService {
	boolean isMutant(DNARequest dna) throws Exception;
	Stats stats();
}
