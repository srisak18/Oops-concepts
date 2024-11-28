package MultiThreading;
import java.util.Scanner;

class Demo12 extends Thread
{
	public void run() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n1: ");
		int n1 = scan.nextInt();
		System.out.println("Enter n2: ");
		int n2 = scan.nextInt();
		scan.close();
		int sum = n1 + n2;
		System.out.println("Sum of n1 and n2 are " + sum);
		
	}
}

class Demo13 extends Thread
{
	@Override
	public void run() {
		try {
			System.out.println("Printing Characters ...");
			for(int i=65; i<=75; i++) {
				System.out.println((char)i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

class Demo14 extends Thread{
	
	@Override
	public void run() {
		
		try {
			System.out.println("Printing Numbers...");
			for(int i=1; i<=10; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}



public class Demo11 {
	public static void main(String[] args) {
		
		Demo12 d1 = new Demo12();
		Demo13 d2 = new Demo13();
		Demo14 d3 = new Demo14();
		
		d1.start();
		d2.start();
		d3.start();
		
	}

}
