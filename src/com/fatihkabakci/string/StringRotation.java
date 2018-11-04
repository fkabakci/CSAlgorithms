package com.fatihkabakci.string;
/**
 * 
 * @author fkabakci
 * Given two strings, check if one of them is a rotation of another
 * Rotation means that first n part of a string is swapped up to the tail of the string.
 * 
 * fatihkabakci -- kabakcifatih
 * 
 * f-a-t-i-h switches to the tail.
 */
public class StringRotation {

	public static boolean isRotation(String s1, String s2) {
		for(int i = 0; i < s1.length(); i++) {
			String prefix = s1.substring(0, i + 1);
			String postfix = s1.substring(i + 1);
			System.out.println(prefix + " " + postfix);
			if(postfix.concat(prefix).equals(s2))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isRotation("fatihkabakci", "kabakcifatih"));
	}
}