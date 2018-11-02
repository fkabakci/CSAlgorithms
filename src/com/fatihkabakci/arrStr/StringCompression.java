package com.fatihkabakci.arrStr;
/**
 * 
 * @author fkabakci
 * Given a string, compress it by performing the following format:
 * Count consecutive characters and put the value of the character and how many times it appears in the string.
 * 
 * ffbbccccpp -- f2b2c4p2
 */
public class StringCompression {

	public static String compress(String str) {
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			counter++;
			if(i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
				sb.append(str.charAt(i));
				sb.append(counter);
				counter = 0;
			}
		}
		return (sb.length() < str.length()) ? sb.toString() : str;
	}
	
	public static void main(String[] args) {
		System.out.println(compress("ffbbccccpp"));
	}
}