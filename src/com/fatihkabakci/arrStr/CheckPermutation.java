package com.fatihkabakci.arrStr;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author fkabakci
 * Given two strings, determine if one of them is permutation of the other.
 * O(n) solution
 * 
 * abc -- cba -- true
 * abc -- dac -- false
 */
public class CheckPermutation {
	private static Map<Character, Integer> getMap(String str) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for(char key : str.toCharArray()) {
			if(m.containsKey(key))
				m.put(key, m.get(key) + 1);
			else
				m.put(key, 1);
		}
		return m;
	}
	public static boolean checkPermutation(String strA, String strB) {
		if(strA.length() != strB.length())
			return false;
		
		Map<Character, Integer> mapA = getMap(strA);
		Map<Character, Integer> mapB = getMap(strB);
		
		for(Entry<Character, Integer> e : mapA.entrySet()) {
			if(mapB.get(e.getKey()) == null || e.getValue() != mapB.get(e.getKey()))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkPermutation("abc", "abc"));
	}
}