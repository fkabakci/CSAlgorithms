package com.fatihkabakci.string;

public class HashTable<K, V> {
	Node<K, V>[] table = new Node[26];
	
    class Node<A, B> {
		K key;
		V value;
		Node<K, V> next;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}		
	}
    
    private int hash(K key) {
    	return key.hashCode() % 26;
    }
    
    public V get(K key) {
    	int index = hash(key);
    	for(Node<K, V> i = table[index]; i != null; i = i.next) {
    		if(i.key.equals(key)) {
    			return i.value;
    		}
    	}
    	return null;
    }
    
    public void put(K key, V value) {
    	int index = hash(key);
    	for(Node<K, V> i = table[index]; i != null; i = i.next) {
    		if(i.key.equals(key)) {
    			i.value = value;
    			return;
    		}
    	}
    	table[index] = new Node<K, V>(key, value);
    }
	
	public static void main(String[] args) {
		
		HashTable<String, String> ht = new HashTable<String, String>();
		ht.put("Fatih", "1234");
		ht.put("Dilan", "2335");
		ht.put("Esra", "Undefined");
		ht.put("Dilan", "2331");
		
		System.out.println(ht.get("Fatish"));
		
	}
}