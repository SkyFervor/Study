package question.alibaba;

import java.util.Random;

/**
 * 模拟多线程购物
 */
public class Shop {
	class User {
		String account;
		int price;

		public User(String account) {
			this.account = account;
			price = 0;
		}
	}

	User[] users = new User[4];
	int amount = 2000000;
	Random random = new Random();

	public static void main(String[] args) {
		Shop s = new Shop();
		s.init();
	}

	public void init() {
		users[0] = new User("张三");
		users[1] = new User("李四");
		users[2] = new User("王五");
		users[3] = new User("赵六");

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while (amount > 0) {
					int i = random.nextInt(users.length);
					User user = users[i];

					int price = (random.nextInt(20) + 1) * 1000;

					shop(user, price);
				}
			}
		};
		Thread t1 = new Thread(runnable);
		t1.start();
		Thread t2 = new Thread(runnable);
		t2.start();

		while (t1.isAlive() || t2.isAlive()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (User user : users) {
			System.out.println(user.account + " 购买了：" + user.price);
		}
	}

	public void shop(User user, int price) {
		synchronized (Shop.class) {
			if (amount < price)
				return;
			/*
			if (user.price + price > 20000)
				return;
				*/

			user.price += price;
			amount -= price;
		}
	}
}
