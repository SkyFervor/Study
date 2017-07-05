public class Priority implements Runnable {
	public void run() {
		for (int i = 0; i < 5; ++i) {
			System.out.println(Thread.currentThread().getName() + "运行" + i);
		}
	}

	public static void main(String[] args) {
		Thread h1 = new Thread(new Priority(), "A");
		Thread h2 = new Thread(new Priority(), "B");
		Thread h3 = new Thread(new Priority(), "C");

		h1.setPriority(8);
		h2.setPriority(2);
		h3.setPriority(6);

		h1.start();
		h2.start();
		h3.start();
	}

}
