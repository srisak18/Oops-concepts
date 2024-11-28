package Accenture_Practice_Questions;

import java.util.Scanner;

public class ValidParenthesis {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		
		String res = validParenthesis(input);
		System.out.println(res);
	}
	
	public static String validParenthesis(String s) {
		int par =0, curly=0, sq =0;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(') {
				par++;
			}
			else if(ch == '[') {
				sq++;
			}
			else if(ch == '{') {
				curly++;
			}
			else if(ch == ')') {
				par--;
			}
			else if(ch == ']') {
				sq--;
			}
			else if(ch == '}') {
				curly--;
			}
		}
		if(par == 0 && sq == 0 && curly == 0) {
			return "true";
		}
		else {
			return "false";
		}
	}
}
