package com.fatihkabakci.treesgraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fkabakci
 * 
 * Given a directed graph, find out if there is a route between two nodes
 * 
 * DFS Solution: (Recursive)
 * Go as deep as neighbors s neighbors first. If there is no unvisited node left and 
 * still no route found, then go upper and see other nodes. If anything valid found,
 * then return true
 * 
 * BFS Solution: (Iterative)
 * Go first check closest neighbors. If nothing found, then go each of neighbors.
 */
public class DirectedGraph<V> {
	Map<Node<V>, List<Node<V>>> graph = new HashMap<Node<V>, List<Node<V>>>();

	public void add(Node<V> n) {
		graph.put(n, new ArrayList<Node<V>>());
	}

	public void connect(Node<V> from, Node<V> to) {
		if (graph.get(from) == null)
			add(from);
		
		List<Node<V>> neighbors = graph.get(from);
		if (!neighbors.contains(to))
			neighbors.add(to);
	}
	
	private boolean dfs(Node<V> from, Node<V> to) {
		if (from == to)
			return true;

		from.visit(true);

		List<Node<V>> neighbors = graph.get(from);
		for (Node<V> n : neighbors) {
			if (!n.isVisited() && dfs(n, to))
				return true;
		}
		return false;
	}
	
	private boolean bfs(Node<V> from, Node<V> to) {
		Deque<Node<V>> q = new ArrayDeque<Node<V>>();
		q.add(from);

		while (!q.isEmpty()) {
			List<Node<V>> neighbors = graph.get(q.pop());
			for (Node<V> n : neighbors) {
				if (n == to) {
					return true;
				}
				if (!n.isVisited())
					q.add(n);
				n.visit(true);
			}
		}
		return false;
	}
	
	public boolean isValidRoute(Node<V> from, Node<V> to, boolean dfs) {
		return (dfs) ? dfs(from, to) : bfs(from, to);
	}


	public static void main(String[] args) {
		DirectedGraph<Integer> s = new DirectedGraph<Integer>();
		
		Node<Integer> n0 = new Node<Integer>(0);
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		
		s.add(n0);
		s.add(n1);
		s.add(n2);
		s.add(n3);
		s.add(n4);
		s.add(n5);
		
		s.connect(n0, n1);
		s.connect(n0, n4);
		s.connect(n0, n5);
		s.connect(n1, n3);
		s.connect(n1, n4);
		s.connect(n2, n1);
		s.connect(n3, n2);
		s.connect(n3, n4);
		
		System.out.println(s.isValidRoute(n0, n3, true));
	}
}