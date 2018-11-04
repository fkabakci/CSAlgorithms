package com.fatihkabakci.string;
public class Palindrome {
	private int[] getFrequencyTable(String str) {
		int[] ascii = new int['z' - 'a' + 1];
		for(int i = 0; i < str.length(); i++) {
			int code = str.codePointAt(i) - 'a';
			ascii[code]++;
		}
		return ascii;
	}
	public boolean isPossiblyPalindrom(String str) {
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
	
	public boolean isPalindrome(String str) {	
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		
		int l = str.length();
		for(int i = 0; i < l; i++) {
			if(str.charAt(i) != str.charAt(l - 1 - i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		System.out.println(p.isPalindrome("abba"));
	}
}
