package ProducerConsumer.Lock;

public class Producer implements Runnable {
	private int num;
	private Storage storage;

	public Producer(Storage storage) {
		this.storage = storage;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);

				storage.produce(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
