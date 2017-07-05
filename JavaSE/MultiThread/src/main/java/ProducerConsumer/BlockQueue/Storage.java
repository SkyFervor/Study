package ProducerConsumer.BlockQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
	private static final int MAX_SIZE = 100;
	private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(MAX_SIZE);

	public void produce(int num) throws InterruptedException {
		for (int i = 0; i < num; i++) {
			if (list.size() == MAX_SIZE)
				System.out.println("【生产】:" + num + "\t【库存】:" + MAX_SIZE + "\t已满!");
			list.put(new Object());
		}
		System.out.println("【生产】:" + num + "\t【库存】:" + list.size());

	}

	public void consume(int num) throws InterruptedException {
		for (int i = 0; i < num; i++) {
			if (list.size() == 0)
				System.out.println("【消费】:" + num + "\t【库存】:0\t已空!");
			list.take();
		}
		System.out.println("【消费】:" + num + "\t【库存】:" + list.size());
	}
}
