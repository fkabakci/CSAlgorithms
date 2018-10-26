package com.fatihkabakci.arrStr;

/**
 * 
 * @author fkabakci 
 * Replace all spaces with the character %20. Use same char array. No extra space is used.
 */


public class ReplaceSpaceWithCharacters {
	private static int getNumberOfSpaces(char[] str, int length) {
		int numberOfSpaces = 0;
		for(int i = 0; i < length; i++) {
			if(str[i] == ' ') {
				numberOfSpaces++;
			}
		}
		return numberOfSpaces;
	}
	
	public static void replaceAllSpaces(char[] str, int length) {
		int numberOfSpaces = getNumberOfSpaces(str, length);		
		int arrIndex = numberOfSpaces * 2 + length - 1;
		for(int i = length - 1; i >= 0 ; i--) {
			if(str[i] == ' ') {
				str[arrIndex--] = '0';
				str[arrIndex--] = '2';
				str[arrIndex--] = '%';
				
			}else {
				str[arrIndex--] = str[i];
			}
		}
	}
	public static void main(String[] args) {
		// extra space at the end of the string has to be !
		char[] input = "Fatih Kabakci SF USA       ".toCharArray();
		replaceAllSpaces(input, 20);
		System.out.println(input);
	}
}