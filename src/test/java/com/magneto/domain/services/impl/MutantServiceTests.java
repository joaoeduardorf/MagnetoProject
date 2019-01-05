package com.magneto.domain.services.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.magneto.domain.entities.DNA;
import com.magneto.domain.repositories.interfaces.IMutantRepository;

@RunWith(MockitoJUnitRunner.class)
public class MutantServiceTests {
	
	String[] validMutantSequence = {"ATGCGA","AAGTGC","ATATGT","AGAAGG","CCCCTA","TCACTG"};
	String[] validHumanSequence = { "GTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
	String[] invalidMatrixNN = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACT" };
	String[] invalidNucleotide = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTB" };
	
	@Autowired
	private IMutantRepository _mutantRepository;
	
//	public MutantServiceTests(IMutantRepository mutantRepository) {
//		_mutantRepository = mutantRepository;
//	}
	
//	@Before
//	public void setUp() throws Exception {
//		
//	}

	@Test(expected = Exception.class)
	public void testValidMutantSequence() throws Exception {
		MutantService mutantService = new MutantService(_mutantRepository);
		assertTrue(mutantService.isMutant(new DNA(validMutantSequence)));
	}
	
	@Test
	public void testInvalidMatrixNN() {

		MutantService mutantService = new MutantService(_mutantRepository);
		try {
			mutantService.isMutant(new DNA(invalidMatrixNN));
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Invalid matrix N*N"));
		}
	}

	@Test
	public void testInvalidNucleotide() {

		MutantService mutantService = new MutantService(_mutantRepository);
		try {
			mutantService.isMutant(new DNA(invalidNucleotide));
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Invalid sequence of nucleotides"));
		}
	}
}
