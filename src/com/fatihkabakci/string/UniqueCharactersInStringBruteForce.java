package com.fatihkabakci.string;

/**
 * 
 * @author fkabakci 
 * Find out if a string has all unique characters -- Brute Force O(n2) solution
 */

public class UniqueCharactersInStringBruteForce {
	public static boolean isUnique(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String computer = "Computer";
		String printer = "Printer";

		System.out.println(isUnique(computer));
		System.out.println(isUnique(printer));
	}
}