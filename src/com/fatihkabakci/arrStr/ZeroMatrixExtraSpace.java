package com.fatihkabakci.arrStr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @param fkabakci
 * if matrix[i][j] has 0, then set its entire row and column to 0.
 * Solution:
 * First determine where the zeros are. Then, set their entire rows and columns to 0.
 * It tracks all zeros and save their indexes. Then sets rows and columns to 0 where the indexes belong to.
 */

public class ZeroMatrixExtraSpace {
	public static void zeroMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		List<Integer> li = new ArrayList<Integer>();
		List<Integer> lj = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (matrix[i][j] == 0) {
					li.add(i);
					lj.add(j);
				}
        	
		Iterator<Integer> r = li.iterator();
		Iterator<Integer> c = lj.iterator(); 
		while(r.hasNext() && c.hasNext()) {
			int i = (int) r.next();
			int j = (int) c.next();
			
			for(int k = 0; k < n; k++)
				matrix[i][k] = 0;
			for(int k = 0; k < m; k++)
				matrix[k][j] = 0;
		}
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