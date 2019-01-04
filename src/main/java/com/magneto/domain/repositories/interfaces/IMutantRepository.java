package com.magneto.domain.repositories.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magneto.domain.entities.DNA;

public interface IMutantRepository extends MongoRepository<DNA, String> {
//	void save(DNA dna);
//	String getStatistic();
}
