package com.fatihkabakci.searchandsort;

public class QuickSort {
	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public void sort(int[] arr, int l, int r) {
		int index = partition(arr, l, r);
		if (l < index - 1) {
			sort(arr, l, index - 1);
		}
		if (index < r) {
			sort(arr, index, r);
		}
	}

	public int partition(int[] arr, int l, int r) {
		int pivot = arr[(l + r) / 2];
		while (l <= r) {
			while (pivot > arr[l])
				l++;
			while (pivot < arr[r])
				r--;
			if (l <= r) {
				swap(arr, l, r);
				l++;
				r--;
			}
		}
		return l;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 5, 1, 4, 6, 0 };
		QuickSort qs = new QuickSort();
		qs.sort(arr);
		for (int a : arr)
			System.out.print(a + " ");
	}
}
