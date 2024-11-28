package April_24;
import java.util.Scanner;

class OverAgeException extends Exception{
	
	@Override
	public String getMessage() {
		return "The age is nearly or more than 65...";
	}
}

class UnderAgeException extends Exception{

	@Override
	public String getMessage() {
		return "Invalid input...";
	}
}

class Office{
	int age = 0 ;
	Scanner scan = new Scanner(System.in);
	
	public void acceptInput() {
		
		System.out.println("Enter your age: ");
		age = scan.nextInt();
		
	}
	
	public void validateAge() throws  UnderAgeException, OverAgeException {
		if(age>=18 && age<65) {
			System.out.println("Get your license");
		}
		else if(age>=65) {
			OverAgeException o = new OverAgeException();
			System.out.println(o.getMessage());
			throw o;
		}
		else if(age<18) {
			UnderAgeException u = new UnderAgeException();
			System.out.println(u.getMessage());
			throw u;
		}
	}
	
	
}

class Rto{
	public void init() {
		
		Office of = new Office();
		try {
			of.acceptInput();
			of.validateAge();
		}
		catch(OverAgeException o) {
			System.out.println("Sorry! You can't apply for lisence");
			
		}
		catch(UnderAgeException u1) {
			try {
				of.acceptInput();
				of.validateAge();
			}
			catch(OverAgeException o) {
				System.out.println("Sorry! You can't apply for lisence");
				
			}
			catch(UnderAgeException u2) {
				try {
					of.acceptInput();
					of.validateAge();
				}
				catch(OverAgeException o) {
					System.out.println("Sorry! You can't apply for lisence");
					
				}
				catch(UnderAgeException u3) {
					try {
						of.acceptInput();
						of.validateAge();
					}
					catch(OverAgeException o) {
						System.out.println("Sorry! You can't apply for lisence");
						
					}
					catch(UnderAgeException u4) {
						System.out.println("Sorry! you're blocked. Because you are too young...");
					}
				}
			}
			
		}
		
	}
	
	
}

public class Transport {
	public static void main(String[] args) {
		
		Rto r = new Rto();
		r.init();
		
	}
}
