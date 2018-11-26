package com.fatihkabakci.string;

/**
 * 
 * @author fkabakci
 * Given an array, find the ways to reach out to target by addition and subtraction operations
 */
public class NumberOfWaysTargetInArray {
	public static int ways = 0;
	
	public static int findTotalWays(int[] arr, int i, int acc, int target) {
		if (i >= arr.length && target != acc) 
	        return 0;

	    if (target == acc)
	        return 1;
	  
	    return findTotalWays(arr, i + 1, acc, target)  
	    		+ findTotalWays(arr, i + 1, acc - arr[i], target)
	    		+ findTotalWays(arr, i + 1, acc + arr[i], target);
	}

	public static void main(String[] args) {
		int[] arr = {-3, 1, 3, 5};
		System.out.println(findTotalWays(arr, 0, 0, 6));
	}
}