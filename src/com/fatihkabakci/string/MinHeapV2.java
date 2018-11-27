package com.fatihkabakci.string;

import java.util.List;

import java.util.ArrayList;

/**
 * 
 * @author fkabakci
 * MinHeap implementation using arrays
 * 
 * Insertion: add at the end of level. Then bubble up while current is less than its parent.
 * 
 * Extraction: get root data. Move last element to the top. 
 * Then bubble down while current is greater than one of its children
 */

public class MinHeapV2 {

	List<Integer> heap = new ArrayList<Integer>();
	
	public void insert(int data) {
		heap.add(data);
		int i = heap.size() - 1;
		while(i > 0 && heap.get(i) < heap.get(parent(i))) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	public int extract() {
		int top = heap.get(0);
		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		minHeapify(0);
		return top;
	}
	
	private void minHeapify(int i) {
		
		int current = i;
		int left = left(i);
		int right = right(i);
		
		int smallest = current;
		if(left < heap.size() && heap.get(smallest) > heap.get(left))
			smallest = left;
		if(right < heap.size() && heap.get(smallest) > heap.get(right))
			smallest = right;
		
		if(smallest != current) {
			swap(smallest, current);
			minHeapify(smallest);
		}
	}

	public void print() {
		for(int i : heap) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
	
	private void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	public int parent(int i) {
		return (i - 1) / 2;
	}
	
	public int left(int i) {
		return 2 * i + 1;
	}
	
	public int right(int i) {
		return 2 * i + 2;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 14, 23, 32, 41, 87, 90, 50, 64, 53};
		MinHeapV2 heap = new MinHeapV2();
		for(int i : arr)
			heap.insert(i);
		
		heap.print();
		int top = heap.extract();
		System.out.println(top);
		heap.print();
	}
}