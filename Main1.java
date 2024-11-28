package ComparableAndComparator;

import java.util.Scanner;
import java.util.TreeSet;

class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private String email;
	private String department;
	private int salary;
	
	public Employee(){
		
	}
	
	public Employee(int id, String name, String email, String department, int salary) {
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
	
	public String toString() {
		return "\n\nId: " + id + "\nName: " + name + "\nE-mail: " + email + "\nDepartment: " + department + "\nSalary: " + salary;
	}
	
	/*public int compareTo(Employee e2) {
		Employee e1 = this;
		Integer i1 = e1.id;
		Integer i2 = e2.id;
		
		return i1.compareTo(i2);
		
	}*/
	
	/*public int compareTo(Employee e2) {
		Employee e1 = this;
		
		return e1.name.compareTo(e2.name);
	}*/
	
	/*public int compareTo(Employee e2) {
		Employee e1 = this;
		return e1.email.compareTo(e2.email);
	}*/
	
	/*public int compareTo(Employee e2) {
		Employee e1 = this;
		return e1.department.compareTo(e2.department);
	}*/
	
	/*public int compareTo(Employee e2) {
		Employee e1 = this;
		Integer i1 = e1.salary;
		Integer i2 = e2.salary;
		return -1 * i1.compareTo(i2);
	}*/
	
	@Override
	public int compareTo(Employee e2) {
		Employee e1 = this;
		if(e1.name.equals(e2.name)) {
			return e1.email.compareTo(e2.email);
		}
		return e1.name.compareTo(e2.name);
	}
	
	
}

public class Main1 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number Of Employees: ");
		int n = scan.nextInt();
		scan.nextLine();
		
		TreeSet<Employee> ts = new TreeSet<Employee>();
		for(int i=0; i<n; i++) {
			String s = scan.nextLine();
			String[] str = s.split(",");
			Employee e = new Employee(Integer.parseInt(str[0]), str[1], str[2], str[3], Integer.parseInt(str[4]));
			ts.add(e);
		}
		
		scan.close();
		
		System.out.println(ts);
		
	}

}
