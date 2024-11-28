package MultiThreading;

class Warrior extends Thread{
	
	String r1 = "Brahmastra";
	String r2 = "Pashupatastra";
	String r3 = "Sarpastra";
	
	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		
		if(name.equals("ARJUNAN")) {
			Arjunan();
		}
		else {
			Karnan();
		}
		
	}
	
	
	void Arjunan() {
		
		try {
			
			Thread.sleep(3000);
			synchronized (r1) {
				System.out.println("Arjunan acquired "+r1);
				Thread.sleep(3000);
				synchronized (r2) {
					System.out.println("Arjunan acquired "+r2);
					Thread.sleep(3000);
					synchronized (r3) {
						System.out.println("Arjunan acquired "+r3);
					}
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	void Karnan() {
		
		try {
			
			Thread.sleep(3000);
			synchronized (r1) {
				System.out.println("Karnan acquired "+r1);
				Thread.sleep(3000);
				synchronized (r2) {
					System.out.println("Karnan acquired "+r2);
					Thread.sleep(3000);
					synchronized (r3) {
						System.out.println("Karnan acquired "+r3);
					}
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}


public class LifeCycle {
	public static void main(String[] args) {
		
		Warrior w1 = new Warrior();
		Warrior w2 = new Warrior();
		
		w1.setName("ARJUNAN");
		w2.setName("KARNAN");
		
		w1.start();
		w2.start();
	}

}
