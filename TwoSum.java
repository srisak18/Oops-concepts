package Accenture_Practice_Questions;

import java.util.Scanner;

public class TwoSum {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
		}
		
		int target = scan.nextInt();
		scan.close();
		
		twoSum(a, target);
	}
	
	public static void twoSum(int[] a, int target) {
		int i=0;
		while(i<a.length-1) {
			for (int j = i+1; j < a.length; j++) {
				int sum = a[i] + a[j];
				if(sum == target) {
					System.out.println(i + "," + j);
				}
				sum=0;
			}
			i++;
		}
		
	}

}
