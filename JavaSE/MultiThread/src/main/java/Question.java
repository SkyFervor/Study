public class Question {
	public static void main(String[] args) throws InterruptedException {
		fun1();
	}

	/**
	 * 两个相同的线程，run方法中循环50次对共享变量sum执行+1操作
	 * Q：sum最终的取值范围
	 * A：2-100
	 * 100是最理想的情况，两个线程执行过程中没有产生同步问题
	 * 2的由来：
	 * 1)线程1取sum==0，线程2执行49次循环sum==49
	 * 2)线程1在读得的过期sum==0的情况下执行1次循环sum==1
	 * 3)线程2取sum==1，线程1执行49次循环sum==50，线程1退出
	 * 4)线程2在读得的过期sum==1的情况下执行1次循环sum==2，线程2退出
	 */
	public static void fun1() throws InterruptedException {
		Thread t1 = new MyThread(true);
		Thread t2 = new MyThread(false);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(MyThread.sum);
	}
}

class MyThread extends Thread {
	public volatile static int sum = 0;
	private boolean sub; // true为线程1，false为线程2

	public MyThread(boolean sub) {
		this.sub = sub;
	}

	@Override
	public void run() {
		// 线程1
		if (sub) {
			for (int i = 1; i <= 50; i++) {
				int value = sum; // 取sum值
				if (i == 1) {
					try {
						Thread.sleep(100); // 第一个线程取得0时等一会
					} catch (InterruptedException e) {
					}
				}
				sum = value + 1; // sum值加1
				if (i == 1) {
					try {
						Thread.sleep(200); // 第一个线程赋值为1时等待第二线程取到1时再运行
					} catch (InterruptedException e) {
					}
				}
			}
		}
		// 线程2
		else {
			try {
				Thread.sleep(1); // 第二个线程延迟一会执行
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 1; i <= 50; i++) {
				int value = sum; // 取sum值
				if (i == 50) {
					try {
						Thread.sleep(250); // 从第一个线程取得1之后等第一个线程运行完再执行加到2
					} catch (InterruptedException e) {
					}
				}
				sum = value + 1; // sum值加1
				if (i == 49) {
					try {
						Thread.sleep(150); // 第一个循环完49次之后等一会
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}