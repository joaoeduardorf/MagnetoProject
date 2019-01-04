package com.magneto.application.interfaces;

import com.magneto.application.dtos.DNARequest;

public interface IMutantAppService {
	boolean isMutant(DNARequest dna) throws Exception;
}
