package com.magneto.domain.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class DNA {
	@Id
	public ObjectId _id;
	private String[] sequence;
	private boolean isMutant;
	
	public void setId(ObjectId id) {
		_id = id;
	}

	public DNA(String[] nucleotideSequence) {
		setSequence(nucleotideSequence);
	}
	public String[] getSequence() {
		return sequence;
	}

	public void setSequence(String[] sequence) {
		this.sequence = sequence;
	}
	
	public boolean isMatrixNN() {
		boolean result = true;
		int nLines = sequence.length;
		
		for (String string : sequence) {
			if(string.length() != nLines) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public boolean isValidNucleotide() {
		for (String string : sequence) {
			if(!string.matches("^[A|T|C|G]*$")) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isMutant() {
		char[][] matrix = new char[sequence.length][];;
		int quantityOfFindedSequences = 0;
		
		for (int i = 0; i < sequence.length; i++) {
            matrix[i] = sequence[i].toCharArray();
        }

        for (int i = 0; i < matrix.length; i++) {
            String letterInLine = "";
            String letterInCollunm = "";
            int matchInLine = 0;
            int matchInCollunm = 0;

            for (int j = 0; j < matrix[i].length; j++) {

//            	basicSearch(letterInLine, Character.toString(matrix[i][j]), matchInLine);
//            	basicSearch(letterInCollunm, Character.toString(matrix[j][i]), matchInCollunm);
            	
                if (letterInLine.equals(Character.toString(matrix[i][j]))) {
                    matchInLine++;
                } else {
                    letterInLine = Character.toString(matrix[i][j]);
                    matchInLine = 0;
                }

                if (letterInCollunm.equals(Character.toString(matrix[j][i]))) {
                    matchInCollunm++;
                } else {
                    letterInCollunm = Character.toString(matrix[j][i]);
                    matchInCollunm = 0;
                }

                if (matchInLine == 3) {
                    System.out.println("Sequence match in line");
                    matchInLine = 0;
                    quantityOfFindedSequences++;
                }

                if (matchInCollunm == 3) {
                    System.out.println("Sequence match in collumn");
                    matchInCollunm = 0;
                    quantityOfFindedSequences++;
                }
            }
        }
        
        if(quantityOfFindedSequences > 1) {
        	isMutant = true;
        	return true;
        }else {
        	isMutant = false;
        	return false;
        }
	}
	
	private int basicSearch(String nucleotideForSearch, String actualNucleotideOfSequence,int matchQuantity) {
		if (nucleotideForSearch.equals(actualNucleotideOfSequence)) {
			matchQuantity++;
        } else {
        	nucleotideForSearch = actualNucleotideOfSequence;
        }
		
		return matchQuantity;
	}
	
	private boolean deepSearch() {
		return true;
	}
}
