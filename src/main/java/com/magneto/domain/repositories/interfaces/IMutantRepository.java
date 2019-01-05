package com.magneto.domain.repositories.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magneto.domain.entities.DNA;

public interface IMutantRepository extends MongoRepository<DNA, String> {
    @Query(value = "{'isMutant': true}", count = true)
    long countMutant();
    @Query(value = "{'isMutant': false}", count = true)
    long countHuman();
}
