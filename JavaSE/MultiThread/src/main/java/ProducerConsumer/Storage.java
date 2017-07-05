package ProducerConsumer;

import java.util.LinkedList;
import java.util.List;

public class Storage {
	private static final int MAX_SIZE = 100;
	private List<Object> list = new LinkedList<Object>();

	public void produce(int num) throws InterruptedException {
		synchronized (list) {
			while (list.size() + num > MAX_SIZE) {
				System.out.println("【生产】:" + num + "\t【库存】:" + list.size() + "\t暂时不能执行生产任务!");

				list.wait();
			}

			for (int i = 0; i < num; i++)
				list.add(new Object());

			System.out.println("【生产】:" + num + "\t【库存】:" + list.size());

			list.notifyAll();
		}
	}

	public void consume(int num) throws InterruptedException {
		synchronized (list) {
			while (list.size() < num) {
				System.out.println("【消费】:" + num + "\t【库存】:" + list.size() + "\t暂时不能执行消费任务!");

				list.wait();
			}

			for (int i = 0; i < num; i++)
				list.remove(0);

			System.out.println("【消费】:" + num + "\t【库存】:" + list.size());
			list.notifyAll();
		}
	}
}
