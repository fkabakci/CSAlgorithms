package com.fatihkabakci.string;

public class RotateMatrix {
	/**
	 * 
	 * @param matrix
	 * replace i-j with j-i pairs
	 */
	public static void transpose(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}
	
	/**
	 * reverses each row of transpose -- clockwise
	 */
	public static void rotateToRight(int[][] matrix) {
		transpose(matrix);
		
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
	}
	
	/**
	 * reverses each column of transpose -- anti-clockwise
	 */
	public static void rotateToLeft(int[][] matrix) {
		transpose(matrix);
		
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n/2; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = temp;
			}
		}
	}
	
	public static void print(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++)
        		System.out.print(matrix[i][j]+ " ");
        	System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4},
						  {5, 6, 7, 8},
						  {9, 10, 11, 12},
						  {13, 14, 15, 16}};
		print(matrix);
		rotateToRight(matrix);
		print(matrix);
	}
}