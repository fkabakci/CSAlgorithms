package com.fatihkabakci.treesgraphs.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author fkabakci
 *
 * There are items and dependencies that need to be built in order. For example, in order to build a, b needs to be built first.
 * a is dependent on b. Problem is to build an order list under some dependencies.
 * 
 * Solution: Depth First Search
 */
public class BuildOrder<V> {
	Map<Node<V>, List<Node<V>>> graph = new HashMap<Node<V>, List<Node<V>>>();

	Queue<Node<V>> order = new ArrayDeque<Node<V>>();

	public void add(Node<V> n) {
		graph.put(n, new ArrayList<Node<V>>());
	}

	public void add(Node<V> node, Node<V> sub) {
		if (graph.get(node) == null)
			add(node);

		List<Node<V>> dependents = graph.get(node);
		if (!dependents.contains(sub))
			dependents.add(sub);
	}

	public void track() {
		// add items that do not have dependencies first
		Set<Entry<Node<V>, List<Node<V>>>> set = graph.entrySet();
		Iterator<Entry<Node<V>, List<Node<V>>>> it = set.iterator();
		while (it.hasNext()) {
			Node<V> project = it.next().getKey();
			if (graph.get(project).size() == 0) {
				order.add(project);
				it.remove();
			}
		}

		set = graph.entrySet();
		it = set.iterator();
		while (it.hasNext()) {
			Node<V> project = it.next().getKey();
			dfs(project);
			if (!order.contains(project))
				order.add(project);
		}
	}

	public void dfs(Node<V> project) {
		project.visit(true);

		List<Node<V>> list = graph.get(project);
		if (list != null) {
			for(Node<V> n : list) {
				if (!n.isVisited())
					dfs(n);
				if (!order.contains(n))
					order.add(n);
			}
		}
	}

	public void traverse() {
		while (!order.isEmpty()) {
			System.out.print(order.poll().v + " ");
		}
	}

	public static void main(String[] args) {
		BuildOrder<Character> s = new BuildOrder<Character>();

		Node<Character> a = new Node<Character>('a');
		Node<Character> b = new Node<Character>('b');
		Node<Character> c = new Node<Character>('c');
		Node<Character> d = new Node<Character>('d');
		Node<Character> e = new Node<Character>('e');
		Node<Character> f = new Node<Character>('f');

		s.add(a);
		s.add(b);
		s.add(c);
		s.add(d);
		s.add(e);
		s.add(f);

		s.add(d, a);
		s.add(b, f);
		s.add(d, b);
		s.add(d, c);
		s.add(a, f);
		s.add(c, d);

		s.track();

		s.traverse();
	}
}