package com.fatihkabakci.arrStr;

/**
 * 
 * @author fkabakci
 * Find out if a string has all unique characters -- O(n) solution
 */

public class UniqueCharactersInString {
	public static boolean isUnique(String str) {
		int length = str.length();
		// ASCII
		if (length > 128) {
			return false;
		}
		boolean[] flag = new boolean[128];
		for (int i = 0; i < length; i++) {
			int code = str.codePointAt(i);
			if (flag[code])
				return false;
			flag[code] = true;
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
