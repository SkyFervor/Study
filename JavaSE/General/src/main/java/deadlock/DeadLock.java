package deadlock;

public class DeadLock {
	
	public static void main(String[] args) {
		Runnable student1 = new WaitForGoHome();
		Runnable student2 = new WaitForGoHome();
		Runnable student3 = new WaitForGoHome();
		new Thread(student1).start();
		new Thread(student2).start();
		new Thread(student3).start();
	}
	
	
}

class WaitForGoHome implements Runnable{
	public Object flag = new Object();

	@Override
	public void run() {
		synchronized (flag) {
			
		}
		System.out.println("Go home");
	}
	
}