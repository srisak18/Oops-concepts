package Accenture_Practice_Questions;

import java.util.Scanner;

public class CommonPrefix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String[] str = new String[n];
		
		for(int i=0; i<str.length; i++) {
			str[i] = scan.nextLine();
		}
		scan.close();
		
		String prefix = commonPrefix(str);
		System.out.println(prefix);
	}
	
	public static String commonPrefix(String[] s) {
		String t = "";
		int i=0;
		while(i<s[0].length()) {
			char ch = s[0].charAt(i);
			for(int j=1; j<s.length; j++) {
				if(ch != s[j].charAt(i)) {
					return t;
				}
			}
			t = t + ch;
			i++;
		}
		return t;
	}

}
