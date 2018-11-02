package com.fatihkabakci.arrStr;

/**
 * 
 * @author fkabakci 
 * Given two strings, determine if they are one-edit away from each other
 * To convert from one to another, there has to be one operation in the following.
 * 1. Insert
 * 2. Replace
 * 3. Remove
 * fatih - ftih - true
 * fatih - yatih - true
 * fatih - setih - false
 * fatihs - fatih - true
 * O(n) solution
 */
public class OneAway {
	private static boolean isOneAway(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int fault = 0;

		if (Math.abs(l1 - l2) > 1) {
			return false;
		} else if (l1 == l2) {
			for (int i = 0; i < l1; i++) {
				if (s1.charAt(i) != s2.charAt(i))
					fault++;

				if (fault > 1)
					return false;
			}
		} else {
			int i1 = 0, i2 = 0;
			String longer = (l1 > l2) ? s1 : s2;
			String shorter = (l1 > l2) ? s2 : s1;
			while (i1 < longer.length() && i2 < shorter.length()) {
				if (longer.charAt(i1) != shorter.charAt(i2)) {
					i1++;
					fault++;
					if (fault > 1)
						return false;
				} else {
					i1++;
					i2++;
				}
			}
			if (i1 < longer.length() || i2 < shorter.length())
				fault++;
		}
		return fault <= 1;
	}

	public static void main(String[] args) {		
		System.out.println(isOneAway("fatih", "ftih"));
		System.out.println(isOneAway("fatih", "yatih"));
		System.out.println(isOneAway("fatih", "setih"));
		System.out.println(isOneAway("fatihs", "fatih"));
	}
}