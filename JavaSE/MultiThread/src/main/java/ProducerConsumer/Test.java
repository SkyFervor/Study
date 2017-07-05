package ProducerConsumer;

public class Test {
	public static void main(String[] args) {
		Storage storage = new Storage();

		Producer p = new Producer(storage);
		p.setNum(10);

		Consumer c = new Consumer(storage);
		c.setNum(100);

		new Thread(p).start();
		new Thread(c).start();
	}
}
