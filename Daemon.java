package MultiThreading;

class Captain extends Thread
{
	
	@Override
	public void run() {
		
		try {
			BowlingCoach bo = new BowlingCoach();
			bo.setDaemon(true);
			bo.start();
			
			BattingCoach ba = new BattingCoach();
			ba.setDaemon(true);
			ba.start();
			
			System.out.println("Captain entered the Ground..");
			Thread.sleep(2000);
			System.out.println("Captain doing Warmup..");
			Thread.sleep(2000);
			System.out.println("Captain practice Bowling..");
			Thread.sleep(2000);
			System.out.println("Captain practice Fielding..");
			Thread.sleep(2000);
			System.out.println("Captain practice Batting..");
			Thread.sleep(2000);
			System.out.println("Captain gone to Hotel..");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}


class BowlingCoach extends Thread
{
	@Override
	public void run() {
		
		try {
			for( ; ; ) {
				System.out.println("Bowling Coach is in the Ground..");
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


class BattingCoach extends Thread
{
	@Override
	public void run() {
		
		try {
			for( ; ; ) {
				System.out.println("Batting Coach is in the Ground..");
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


public class Daemon {
	public static void main(String[] args) {
		
		Captain c = new Captain();
		c.setName("CAPTAIN");
		c.start();
	}

}
