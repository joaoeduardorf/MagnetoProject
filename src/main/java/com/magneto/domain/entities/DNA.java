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

	public void setSequence(String[] sequence) {
		this.sequence = sequence;
	}

	public boolean isMatrixNN() {
		boolean result = true;
		int nLines = sequence.length;

		for (String string : sequence) {
			if (string.length() != nLines) {
				result = false;
				break;
			}
		}

		return result;
	}

	public boolean isValidNucleotide() {
		for (String string : sequence) {
			if (!string.matches("^[A|a|T|t|C|c|G|g]*$")) {
				return false;
			}
		}
		return true;
	}

	private char[][] createMatrix() {
		char[][] matrix = new char[sequence.length][];
		for (int i = 0; i < sequence.length; i++) {
			matrix[i] = sequence[i].toUpperCase().toCharArray();
		}

		return matrix;
	}

	public boolean isMutant() {
		char[][] matrix = createMatrix();

		isMutant = basicSearchMutantSequence(matrix);

		if (!isMutant) {
			isMutant = deepSearchMutantSequence(matrix);
		}

		return isMutant;
	}
	
	boolean basicSearchMutantSequence(char[][] matrix) {

		int quantityOfFindedSequences = 0;

		for (int i = 0; i < matrix.length; i++) {
			String letterInLine = "";
			String letterInCollunm = "";
			int matchInLine = 0;
			int matchInCollunm = 0;

			for (int j = 0; j < matrix[i].length; j++) {

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
					matchInLine = 0;
					quantityOfFindedSequences++;
				}

				if (matchInCollunm == 3) {
					matchInCollunm = 0;
					quantityOfFindedSequences++;
				}
			}
		}

		return quantityOfFindedSequences > 1;
	}

	boolean deepSearchMutantSequence(char matrix[][]) {
		
		int quantityOfFindedSequences = 0;

		quantityOfFindedSequences = patternSearch(matrix, "AAAA");
		if(quantityOfFindedSequences < 3)
		quantityOfFindedSequences += patternSearch(matrix, "TTTT");
		if(quantityOfFindedSequences < 3)
		quantityOfFindedSequences += patternSearch(matrix, "CCCC");
		if(quantityOfFindedSequences < 3)
		quantityOfFindedSequences += patternSearch(matrix, "GGGG");
		
		quantityOfFindedSequences = quantityOfFindedSequences >> 1;

		return quantityOfFindedSequences > 1;
	}

	int patternSearch(char grid[][], String word) {
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (search2D(grid, row, col, word)) {
					count++;
					if(count > 3) {
						break;
					}
				}
				if(count > 3) {
					break;
				}
			}
		}

		return count;
	}

	boolean search2D(char grid[][], int row, int col, String word) {
		int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		if (grid[row][col] != word.charAt(0))
			return false;

		int len = word.length();

		for (int dir = 0; dir < 8; dir++) {
			int k;
			int rd = row + x[dir];
			int cd = col + y[dir];

			for (k = 1; k < len; k++) {
				if (rd >= grid.length || rd < 0 || cd >= grid[k].length || cd < 0)
					break;

				if (grid[rd][cd] != word.charAt(k))
					break;

				rd += x[dir];
				cd += y[dir];
			}

			if (k == len)
				return true;
		}
		return false;
	}
}
