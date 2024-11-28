package Accenture_Practice_Questions;

import java.util.Scanner;

public class FizzBuzz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		fizzBuzz(n);
	}
	
	public static void fizzBuzz(int n) {
		String f = "fizz", b = "buzz";
		for(int i=1; i<=n; i++) {
			if(i%3 == 0 && i%5 == 0) {
				System.out.println(f + b);
			}
			else if(i%3 == 0) {
				System.out.println(f);
			}
			else if(i%5 == 0) {
				System.out.println(b);
			}
			else {
				System.out.println(i);
			}
		}
	}

}
