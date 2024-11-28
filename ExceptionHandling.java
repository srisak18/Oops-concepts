package April_24;

import java.util.InputMismatchException;
import java.util.Scanner;

class Demo1{
	void alpha(){
		System.out.println("Connection - 4 Established");
		try {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int n = scan.nextInt();
		int[] a = new int[n];
		System.out.println("Enter a value to be inserted:");
		int element = scan.nextInt();
		System.out.println("Enter the index value to insert the element:");
		int index = scan.nextInt();
		a[index] = element;
		scan.close();
		System.out.println(a[index]);
		}		
		catch(ArithmeticException ae) {
			System.out.println("Provide a non - zero number..");
		}
		catch(NegativeArraySizeException nase) {
			System.out.println("Be Positive..");
		}
		catch(InputMismatchException ime) {
			System.out.println("Check the Input Data type...");
		}
		catch(ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("Be in your limits...");
		}
		catch(Exception e) {
			System.out.println("Invalid input. Please try again..");
		}
		
		System.out.println("Connection - 4 Terminated");
	}
}


class Demo2{
	void beta() {
		System.out.println("Connection - 3 Established");
		Demo1 d1 = new Demo1();
		d1.alpha();
		System.out.println("Connection - 3 Terminated");
	}
}


class Demo3{
	void gamma() {
		System.out.println("Connection - 2 Established");
		Demo2 d2 = new Demo2();
		d2.beta();
		System.out.println("Connection - 2 Terminated");
	}
}


public class ExceptionHandling {
	public static void main(String[] args) {
		
		System.out.println("Connection - 1 Established");

		Demo3 d3 = new Demo3();
		d3.gamma();
		
		System.out.println("Connection - 1 Terminated");
	}
}
