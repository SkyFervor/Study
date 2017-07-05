public class Daemon implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "在运行");
		}
	}

	public static void main(String[] args) {
		Daemon test = new Daemon();
		Thread demo = new Thread(test, "线程");

		demo.setDaemon(true);
		demo.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
