package com.fatihkabakci.arrStr;

/**
 * 
 * @author fkabakci
 * Given a string, determine if it is a permutation of palindrome.
 * O(n) solution
 */
public class CheckPermutationOfPalindrome {
	private static int[] getFrequencyTable(String str) {
		int[] ascii = new int['z' - 'a' + 1];
		for(int i = 0; i < str.length(); i++) {
			int code = str.codePointAt(i) - 'a';
			ascii[code]++;
		}
		return ascii;
	}
	
	public static boolean checkPermutationPalindrom(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int[] ascii = getFrequencyTable(str);
		boolean odd = false;
		for(int i = 0; i < ascii.length; i++) {
			if(odd & ascii[i] % 2 == 1) {
				return false;
			}else if(ascii[i] % 2 == 1) {
				odd = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "baba";
		System.out.println(checkPermutationPalindrom(input));
	}
}