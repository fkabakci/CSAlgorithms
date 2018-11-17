package com.fatihkabakci.treesgraphs;

public class Node<V> {
	V v;
	boolean visited;
	
	public Node(V v) {
		this.v = v;
	}
	
	public void visit(boolean flag) {
		visited = flag;
	}
	
	public boolean isVisited() {
		return visited;
	}
}
