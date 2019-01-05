package com.magneto.domain.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DNATests {
	String[] validMutantSequence = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
	String[] validMutantSequence2 = { "AAGCGA", "CAATGC", "TTAAGT", "AGAAAG", "TCCCTA", "TCACTG" };
	String[] validHumanSequence = { "GTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
	String[] invalidMatrixNN = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACT" };
	String[] invalidNucleotide = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTB" };

	@Test
	public void testMatrixNNValid() {
		DNA dna = new DNA(validHumanSequence);
		assertTrue("É esperada uma matrix N*N válida", dna.isMatrixNN());
	}

	@Test
	public void testMatrixNNInvalid() {
		DNA dna = new DNA(invalidMatrixNN);
		assertFalse("É esperada uma matrix N*N inválida", dna.isMatrixNN());
	}

	@Test
	public void testNucleotideSequenceValid() {
		DNA dna = new DNA(validHumanSequence);
		assertTrue("É esperada uma com nucleotídeos válidos", dna.isValidNucleotide());
	}

	@Test
	public void testNucleotideSequenceInvalid() {
		DNA dna = new DNA(invalidNucleotide);
		assertFalse("É esperada uma com nucleotídeos inválidos", dna.isValidNucleotide());
	}

	@Test
	public void testHumanSequence() {
		DNA dna = new DNA(validHumanSequence);
		assertFalse("É esperada uma sequencia humana", dna.isMutant());
	}

	@Test
	public void testMutantSequence() {
		DNA dna = new DNA(validMutantSequence);
		assertTrue("É esperada uma sequencia mutant", dna.isMutant());
	}

	@Test
	public void testMutantSequence2() {
		DNA dna = new DNA(validMutantSequence2);
		assertTrue("É esperada uma sequencia mutant", dna.isMutant());
	}

}
