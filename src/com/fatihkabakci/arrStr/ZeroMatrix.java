package com.fatihkabakci.arrStr;

/**
 * 
 * @param fkabakci
 * if matrix[i][j] has 0, then set its entire row and column to 0.
 * Solution:
 * Use first row and column as reference points. No need to save every location of zeros.
 * If there is a zero, just set to 0 first row and column of that particular cell.
 */

public class ZeroMatrix {
	public static void zeroMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean firstColumnHasZero = false;
		for (int i = 0; firstColumnHasZero == false && i < m; i++)
			if(matrix[i][0] == 0)
				firstColumnHasZero = true;
		
		boolean firstRowHasZero = false;
		for (int j = 0; firstRowHasZero == false && j < n; j++)
			if(matrix[0][j] == 0)
				firstRowHasZero = true;
			
		
		// if there is a zero encountered, just mark first cell of those rows and columns
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
		
		// make 0 rows whose their first are 0
		for (int i = 1; i < m; i++)
			if(matrix[i][0] == 0)
				for(int k = 0; k < n; k++)
					matrix[i][k] = 0;

		// make 0 columns whose their first are 0
		for (int j = 1; j < n; j++)
			if(matrix[0][j] == 0)			
				for(int k = 0; k < m; k++)
					matrix[k][j] = 0;
		
		// make 0 for first column
		if(firstColumnHasZero)
			for(int k = 0; k < m; k++)
				matrix[k][0] = 0;
		
		// make 0 for first row
		if(firstRowHasZero)
			for(int k = 0; k < n; k++)
				matrix[0][k] = 0;
		
	}
	
	public static void print(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[i].length; j++)
        		System.out.print(matrix[i][j]+ " ");
        	System.out.println();
		}
		System.out.println();
		
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		
		print(matrix);
		zeroMatrix(matrix);
		print(matrix);

	}
}