package Inheritance;
import java.util.Scanner;

class Shape{
	private String color;
	private boolean filled;
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public boolean getFilled() {
		return filled;
	}
	
	public int getArea(int a, int b) {
		return 0;
	}
	
	public int getArea(int a) {
		return 0;
	}
}

class Rectangle extends Shape{
	int width;
	int height;
	
	@Override
	public int getArea(int width, int height) {
		return width * height;
	}
}

class Square extends Shape{
	int side;
	
	@Override
	public int getArea(int side) {
		return side * side;
	}
}

public class Demo1 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("Rectangle");
		System.out.println("Square");
		String shp = scan.next();
		
		System.out.println("Enter the shape parameters:");
		String str = scan.next();
		String[] a = str.split(",");
		scan.close();
		
		if(shp.equals("Rectangle")) {
			Shape s = new Rectangle();
			int w = Integer.parseInt(a[0]);
			int h = Integer.parseInt(a[1]);
			s.setColor(a[2]);
			s.setFilled(Boolean.parseBoolean(a[3]));
			
			float res =(float) s.getArea(w, h);
			System.out.println("Area of Rectangle: " + res);
		}
		else if(shp.equals("Square")) {
			Shape s = new Square();
			int side = Integer.parseInt(a[0]);
			s.setColor(a[1]);
			s.setFilled(Boolean.parseBoolean(a[2]));
			
			float res = (float) s.getArea(side);
			System.out.println("Area of Square: " + res);
		}
	}
}
