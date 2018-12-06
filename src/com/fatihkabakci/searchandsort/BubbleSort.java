package com.fatihkabakci.searchandsort;

/**
 * 
 * @author fkabakci
 * Bubble Sort O(n2)
 */
public class BubbleSort {
	public void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					arr[i] = arr[i] + arr[j];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {3, 2, 5, 1, 4, 6};
		BubbleSort bs = new BubbleSort();
		bs.sort(arr);
		for(int a : arr)
			System.out.print(a + " ");
	}
}
