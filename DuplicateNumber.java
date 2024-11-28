package Accenture_Practice_Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DuplicateNumber {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
		}
		scan.close();
		
		duplicateNumber(a);
	}
	
	public static void duplicateNumber(int[] a) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<a.length; i++) {
			int c = map.getOrDefault(a[i], 0);
			map.put(a[i], c+1);
		}
		
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		
		for(Map.Entry<Integer, Integer> e : set) {
			if(e.getValue() > 1) {
				System.out.print(e.getKey() + " ");
			}
		}
	}

}
