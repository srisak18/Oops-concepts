package Inheritance;
import java.util.Scanner;

class Vehicle{
	private String make;
	private String model;
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}
	
}

class Car extends Vehicle{
	int year;
	String color;
	
	@Override
	public void setMake(String make) {
		if(!make.equals("null")) {
			super.setMake(make);
		}
	}
	
	@Override
	public void setModel(String model) {
		if(!model.equals("numm")) {
			super.setModel(model);
		}
	}
}

class ElectricCar extends Car{
	int batteryCapacity;
	
	public void chargeBattery(int batteryCapacity) {
		System.out.println("Battery Capacity: "+batteryCapacity + " kWh");
	}
}

public class Demo2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		System.out.println("1. Car");
		System.out.println("2. Electric Car");
		int choice = scan.nextInt();
		
		System.out.println("Enter the vehicle details:");
		scan.nextLine();
		String str = scan.nextLine();
		String[] a = str.split(", ");
		scan.close();
		System.out.println("Vehicle Details:");
		
		if(choice == 1) {
			Car v = new Car();
			v.setMake(a[0]);
			v.setModel(a[1]);
			v.year = Integer.parseInt(a[2]);
			v.color = a[3];
			
			System.out.println("Make: " + v.getMake());
			System.out.println("Model: " + v.getModel());
			System.out.println("Year: " + v.year);
			System.out.println("Color: " + v.color);
		}
		else if (choice == 2) {
			ElectricCar ec = new ElectricCar();
			ec.setMake(a[0]);
			ec.setModel(a[1]);
			ec.year = Integer.parseInt(a[2]);
			ec.color = a[3];
			ec.batteryCapacity = Integer.parseInt(a[4]);
			
			System.out.println("Make: " + ec.getMake());
			System.out.println("Model: " + ec.getModel());
			System.out.println("Year: " + ec.year);
			System.out.println("Color: " + ec.color);
			ec.chargeBattery(ec.batteryCapacity);
			
		}
	}

}
