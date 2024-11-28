package MultiThreading;

class BathRoom
{
	synchronized public void bathroom() {
		
		try {
			String name = Thread.currentThread().getName();
			
			System.out.println(name + " entered the bathroom");
			Thread.sleep(3000);
			System.out.println(name + " using the bathroom");
			Thread.sleep(3000);
			System.out.println(name + " exited from bathroom");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}


class Boy extends Thread{
	
	BathRoom br;
	
	public Boy(BathRoom br) {
		this.br = br;
	}
	
	@Override
	public void run() {
		br.bathroom();
	}
	
}


class Girl extends Thread{
	
	BathRoom br;
	
	public Girl(BathRoom br) {
		this.br = br;
	}
	
	@Override
	public void run() {
		br.bathroom();
	}
	
}


class Others extends Thread{
	
	BathRoom br;
	
	public Others(BathRoom br) {
		this.br = br;
	}
	
	@Override
	public void run() {
		br.bathroom();
	}
	
}


public class Syncro {
	public static void main(String[] args) {
		
		BathRoom br = new BathRoom();
		
		Boy b = new Boy(br);
		b.setName("BOY");
		
		Girl g = new Girl(br);
		g.setName("GIRL");
		
		Others o = new Others(br);
		o.setName("OTHERS");
		
		b.start();
		g.start();
		o.start();
	}

}
