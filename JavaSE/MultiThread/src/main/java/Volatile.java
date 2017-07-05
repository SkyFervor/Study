public class Volatile {

	public static void main(String[] args) throws InterruptedException {
		fun1();
		fun2();
	}

	/**
	 * volatile只是解决了多线程间共享变量的可见性问题，不能解决非原子操作的线程同步问题
	 * 
	 * @throws InterruptedException
	 */
	public static void fun1() throws InterruptedException {
		class MyRunnable implements Runnable {
			public volatile int a = 10;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (a > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(--a);
				}
			}
		}

		MyRunnable r = new MyRunnable();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		t1.start();
		Thread.sleep(100);
		t2.start();
		Thread.sleep(100);
		t3.start();

		t1.join();
		t2.join();
		t3.join();
	}

	/**
	 * flag不加volatile，导致外部对其的修改没有在循环中被读入
	 * 
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	public static void fun2() throws InterruptedException {
		class MyRunnable implements Runnable {
			public boolean flag = false;

			@Override
			public void run() {
				// 无限循环,等待flag变为true时才跳出循环
				while (!flag) {
				}
				System.out.println("loop end");
			}
		}
		;

		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		Thread.sleep(100);
		r.flag = true;

		// 等待3s后强制关闭线程
		Thread.sleep(3000);
		if (t.isAlive())
			System.out.println("Thread still alive");
		t.stop();
	}
}
