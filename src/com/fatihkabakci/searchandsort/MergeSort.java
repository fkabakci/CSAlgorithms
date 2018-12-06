package com.fatihkabakci.searchandsort;

public class MergeSort {
	public int[] mergeSort(int[] arr, int l, int r) {
		if(l == r) {
			int[] h = {arr[l]};
			return h;
		}
		
		int m = (l + r) / 2;

		int[] left = mergeSort(arr, l, m);
		int[] right = mergeSort(arr, m + 1, r);
		
		return merge(left, right);
	}

	public int[] merge(int [] left, int [] right) {
		int[] merged = new int[left.length + right.length];
		
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length) {
			if(left[i] >= right[j]) {
				merged[k++] = right[j++];
			}else {
				merged[k++] = left[i++];
			}
		}
		
		while(i < left.length) {
			merged[k++] = left[i++];
		}
		
		while(j < right.length) {
			merged[k++] = right[j++];
		}
		
		return merged;
	}
	public static void main(String[] args) {
		int[] arr = {3, 2, 5, 1, 4, 6, 0};
		MergeSort bs = new MergeSort();
		int[] sorted = bs.mergeSort(arr, 0, arr.length - 1);
		for(int a : sorted)
			System.out.print(a + " ");
	}
}
