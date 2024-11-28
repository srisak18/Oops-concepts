package Accenture_Practice_Questions;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		
		String result = reverseString(input);
		System.out.println(result);
	}
	
	public static String reverseString(String s) {
		String t = "";
		for(int i=s.length()-1; i>=0; i--) {
			char ch = s.charAt(i);
			t = t + ch;
		}
		return t;
	}

}
