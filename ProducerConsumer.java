package MultiThreading;

class Queue {
	
	private int data;
	boolean isDigitsThere = false;
	
	public synchronized void setData(int data) {
		if(isDigitsThere == false) {
			this.data = data;
			System.out.println("Producer produced the data " + data);
			isDigitsThere = true;
			notify();
		}
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void getData() {
		if(isDigitsThere == true) {
			System.out.println("Consumer consumed the data " + data);
			isDigitsThere = false;
			notify();
		}
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}


class Producer extends Thread{
	
	Queue q;
	
	public Producer(Queue q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		for(int i=1; ;i++ ) {
			q.setData(i);
		}
	}
	
}


class Consumer extends Thread{
	
	Queue q;
	
	public Consumer(Queue q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		for( ; ; ) {
			q.getData();
		}
	}
}


public class ProducerConsumer {
	public static void main(String[] args) {
		
		Queue q = new Queue();
		
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		p.setName("PRODUCER");
		c.setName("CONSUMER");
		
		p.start();
		c.start();
		
	}

}
