package April_24;

import java.util.Scanner;

public class Day01 {
	
	public static long printMaximumPro(int[] a) {
		long p = 1;
		long max = 0;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				if(i != j) {
					p = a[i] * a[j];
				}
				if(max<p) {
					max = p;
				}
			}
		}
		return max;
	}
	
	
	
	public static long printMaximumProduct(int[] a) {
		int m1 = a[0];
		int m2 = a[1];
		long maxProduct = 0;
		for(int i=2; i<a.length; i++) {
			if(a[i] > m1) {
				m2 = m1;
				m1 = a[i];
			}
			else if(a[i] > m2) {
				m2 = a[i];
			}
		}
		maxProduct = m1 * m2;
		return maxProduct;
	}
	
	
	
	public static long printMinimumProduct(int[] a) {
		int m1 = a[0];
		int m2 = a[1];
		long minProduct = 0;
		for(int i=2; i<a.length; i++) {
			if(a[i] < m1) {
				m2 = m1;
				m1 = a[i];
			}
			else if(a[i] < m2) {
				m2 = a[i];
			}
		}
		minProduct = m1 * m2;
		return minProduct;
	}
	
	
	public static int HCF(int a, int b) {
		while(a != 0 && b != 0) {
			if(a>b) {
				a = a%b;
			}
			else {
				b = b%a;
			}
		}
		if(b == 0) {
			return a;
		}
		else {
			return b;
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		
		int res = HCF(a,b);
		System.out.println(res);
		
	}

}
