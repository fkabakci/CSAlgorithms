package com.fatihkabakci.searchandsort;

/**
 * 
 * @author fkabakci
 *
 */
public class MergeSort2 {

	public void sort(int[] arr) {
		split(arr, 0, arr.length - 1);
	}

	public void split(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			split(arr, l, m);
			split(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	public void merge(int[] arr, int l, int m, int r) {
		int[] left = new int[m - l + 1];
		for (int i = l; i < m + 1; i++)
			left[i - l] = arr[i];

		int[] right = new int[r - m];
		for (int i = m + 1; i <= r; i++)
			right[i - m - 1] = arr[i];

		int i = 0, j = 0, k = l;
		while (i < left.length && j < right.length) {
			if (left[i] >= right[j]) {
				arr[k++] = right[j++];
			} else {
				arr[k++] = left[i++];
			}
		}

		while (i < left.length) {
			arr[k++] = left[i++];
		}

		while (j < right.length) {
			arr[k++] = right[j++];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 5, 1, 4, 6, 0 };
		MergeSort2 ms = new MergeSort2();
		ms.sort(arr);
		for (int a : arr)
			System.out.print(a + " ");
	}
}
