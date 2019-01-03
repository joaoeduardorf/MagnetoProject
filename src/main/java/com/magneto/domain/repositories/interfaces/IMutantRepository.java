package com.magneto.domain.repositories.interfaces;

import com.magneto.domain.entities.DNA;

public interface IMutantRepository {
	void save(DNA dna);
	String getStatistic();
}
