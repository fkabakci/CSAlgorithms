package com.fatihkabakci.searchandsort;

/**
 * 
 * @author fkabakci
 * Binary Search log(N)
 */
public class BinarySearch {
	
	/**
	 * Recursive
	 * @param arr
	 * @param data
	 * @return
	 */
	public int binarySearch(int[] arr, int data) {
 		return binarySearch(arr, 0, arr.length - 1, data);
	}
	
	public int binarySearch(int[] arr, int left, int right, int data) {
		int middle = (left + right) / 2;
		
		if(left <= right) {
	 		if(arr[middle] > data) {
				return binarySearch(arr, left, middle - 1, data);
			}else if(arr[middle] < data) {
				return binarySearch(arr, middle + 1, right, data);
			}else {
				return middle;
			}
		}
		return -1;
	}
	
	
	/**
	 * Iterative
	 * @param arr
	 * @param data
	 * @return
	 */
	
	public int binarySearchIterative(int[] arr, int data) {
		return binarySearchIterative(arr, 0, arr.length - 1, data);
	}
	
	public int binarySearchIterative(int[] arr, int left, int right, int data) {
		while(left <= right) {
			int middle = (left + right) / 2;
	 		if(arr[middle] > data) {
				right = middle - 1;
			}else if(arr[middle] < data) {
				left = middle + 1;
			}else {
				return middle;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BinarySearch bs = new BinarySearch();		
		int index = bs.binarySearch(arr, 2);
		System.out.println(index);
	}
}