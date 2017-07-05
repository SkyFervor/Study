package ProducerConsumer;

public class Consumer implements Runnable {
	private int num;
	private Storage storage;

	public Consumer(Storage storage) {
		this.storage = storage;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);

				storage.consume(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
