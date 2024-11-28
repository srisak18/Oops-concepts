package Accenture_Practice_Questions;

import java.util.Scanner;

public class CheckPalindrome {
	public static void main(String[] args) {
		
		Scanner scan  =new Scanner(System.in);
		String input = scan.nextLine().toLowerCase();
		
		String result = isPalindrome(input);
		System.out.println(result);
	}
	
	public static String isPalindrome(String s) {
		s = s.replaceAll("[^a-z]", "");
		int i=0, j=s.length()-1;
		
		while (i<j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}
			else {
				return "false";
			}
		}
		
		return "true";
	}

}
