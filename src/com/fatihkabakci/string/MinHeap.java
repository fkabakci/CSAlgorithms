package com.fatihkabakci.string;

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
public class MinHeap {
	
	int[] arr;
	int size;
	int capacity;
	
	public MinHeap(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		for(int i = 0; i < capacity; i++)
			arr[i] = Integer.MAX_VALUE;
		size = 0;
	}
	
	public void insert(int data) {
		if(size + 1 > capacity) {
			System.err.println("Heap is full");
			return;
		}
		
		int i = (++size) - 1;
		arr[i] = data;
		while(i >= 0 && arr[parent(i)] > arr[i]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	public int extract() {
		if(size < 0) {
			System.err.println("Heap is empty");
			return -1;
		}
		
		int top = arr[0];
		swap(0, size - 1);
		// delete
		arr[size - 1] = Integer.MAX_VALUE;
		size--;
		minHeapify(0);
		return top;
	}
	
	public void minHeapify(int i) {
		int current = i;
		int left = left(i);
		int right = right(i);

		int smallest = current;
		if (left < size && arr[smallest] > arr[left])
			smallest = left;

		if (right < size && arr[smallest] > arr[right])
			smallest = right;
		
		if(smallest != current) {
			swap(current, smallest);
			minHeapify(smallest);
		}
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
	
	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void print() {
		for(int i : arr) {
			if(i == Integer.MAX_VALUE)
				System.out.print("null, ");				
			else
				System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {5, 14, 23, 32, 41, 87, 90, 50, 64, 53};
		MinHeap heap = new MinHeap(20);
		for(int i : arr)
			heap.insert(i);
		heap.print();
		
		int top = heap.extract();
		System.out.println();
		System.out.println(top);
		heap.print();
	}
}