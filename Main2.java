package ComparableAndComparator;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Employee1{
	private int id;
	private String name;
	private String email;
	private String department;
	private int salary;
	
	public Employee1() {

	}
	
	public Employee1(int id, String name, String email, String department, int salary) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return "\n\nId: " + id + "\nName: " + name + "\nE-mail: " + email + "\nDepartment: " + department + "\nSalary: " + salary; 
	}
}

class Demo1 implements Comparator<Employee1>{
	
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		Integer i1 = e1.getId();
		Integer i2 = e2.getId();
		return i1.compareTo(i2);
	}
	
}

class Demo2 implements Comparator<Employee1>{
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		Integer i1 = e1.getId();
		Integer i2 = e2.getId();
		return -1 * i1.compareTo(i2);
	}
}

class Demo3 implements Comparator<Employee1>{
	
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		return e1.getName().compareTo(e2.getName());
	}
}

class Demo4 implements Comparator<Employee1>{
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		return e1.getEmail().compareTo(e2.getEmail());
	}
}

class Demo5 implements Comparator<Employee1>{
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
}

class Demo6 implements Comparator<Employee1>{
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		Integer s1 = e1.getSalary();
		Integer s2 = e2.getSalary();
		return s1.compareTo(s2);
	}
}


public class Main2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Sorting based on \n 1. ID(Low to High)\n 2. ID(High to Low)\n 3. NAME\n 4. E-MAIL\n 5. DEPARTMENT\n 6. SALARY\n");
		int option = scan.nextInt();
		
		Demo1 d1 = new Demo1();
		Demo2 d2 = new Demo2();
		Demo3 d3 = new Demo3();
		Demo4 d4 = new Demo4();
		Demo5 d5 = new Demo5();
		Demo6 d6 = new Demo6();
		
		TreeSet<Employee1> ts = null;
		
		if(option == 1) {
			ts = new TreeSet<Employee1>(d1);
		}
		else if(option ==2){
			ts = new TreeSet<Employee1>(d2);
		}
		else if(option == 3){
			ts = new TreeSet<Employee1>(d3);
		}
		else if(option == 4) {
			ts = new TreeSet<Employee1>(d4);
		}
		else if(option == 5) {
			ts = new TreeSet<Employee1>(d5);
		}
		else if(option == 6){
			ts = new TreeSet<Employee1>(d6);
		}
		else {
			System.out.println("Invalid Choice...");
		}
		
		System.out.println("Enter Number of Employees : ");
		int n = scan.nextInt();
		scan.nextLine();
		
		for(int i=0; i<n; i++) {
			String str = scan.nextLine();
			String[] s = str.split(",");
			Employee1 e = new Employee1(Integer.parseInt(s[0]), s[1], s[2], s[3], Integer.parseInt(s[4]));
			ts.add(e);
		}
		
		scan.close();
		
		System.out.println(ts);
	}

}
