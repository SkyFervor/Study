package ProducerConsumer.Lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
	private ReentrantLock lock = new ReentrantLock();
	private Condition empty = lock.newCondition();
	private Condition full = lock.newCondition();

	private static final int MAX_SIZE = 100;
	private List<Object> list = new LinkedList<Object>();

	public void produce(int num) throws InterruptedException {
		lock.lock();

		while (list.size() + num > MAX_SIZE) {
			System.out.println("【生产】:" + num + "\t【库存】:" + list.size() + "\t暂时不能执行生产任务!");

			full.await();
		}

		for (int i = 0; i < num; i++)
			list.add(new Object());

		System.out.println("【生产】:" + num + "\t【库存】:" + list.size());

		empty.signalAll();
		lock.unlock();
	}

	public void consume(int num) throws InterruptedException {
		lock.lock();

		while (list.size() < num) {
			System.out.println("【消费】:" + num + "\t【库存】:" + list.size() + "\t暂时不能执行消费任务!");

			empty.await();
		}

		for (int i = 0; i < num; i++)
			list.remove(0);

		System.out.println("【消费】:" + num + "\t【库存】:" + list.size());

		full.signalAll();
		lock.unlock();
	}
}
