package Accenture_Practice_Questions;

import java.util.Scanner;

public class MergedTwoSortedArray {
	public static void main(String[] args) {
		
		Scanner scan  =new Scanner(System.in);
		int m = scan.nextInt();
		int[] a1 = new int[m];
		
		for(int i=0; i<a1.length; i++) {
			a1[i] = scan.nextInt();
		}
		
		int n = scan.nextInt();
		int[] a2 = new int[n];
		
		for(int i=0; i<a2.length; i++) {
			a2[i] = scan.nextInt();
		}
		scan.close();
		
		int[] res = mergedTwoSortedArray(a1, a2);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
	public static int[] mergedTwoSortedArray(int[] a1, int[] a2) {
		int[] a = new int[a1.length + a2.length];
		int i=0, j=0, ind=0;
		
		while(i<a1.length && j<a2.length) {
			if(a1[i] < a2[j]) {
				a[ind++] = a1[i++];
			}
			else if(a1[i] > a2[j]) {
				a[ind++] = a2[j++];
			}
		}
		
		while (i<a1.length) {
			a[ind++] = a1[i++];
		}
		
		while (j<a2.length) {
			a[ind++] = a2[j++];
		}
		
		return a;
	}
}
