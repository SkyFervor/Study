import java.util.Scanner;

public class ATM {
	static Account acct = new Account("123456", "123456", 1000, "张三", "工商银行");
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please input your card id:");
		String cardId = scanner.nextLine();
		System.out.println("Please input your password:");
		String password = scanner.nextLine();

		if (!cardId.equals(acct.cardId) || !password.equals(acct.password)) {
			System.out.println("验证失败");
			return;
		}

		System.out.println(acct.realName + "，欢迎使用 " + acct.bankName + " ATM");
		startService();
	}

	static void startService() {
		while (true) {
			System.out.println("\n请选择功能：");
			System.out.println("1.存款\t2.取款\t3.查询\t4.退出");

			switch (scanner.nextInt()) {
			case 1:
				save();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				System.out.println("余额：" + acct.balance);
				break;
			case 4:
				System.out.println("感谢您使用本ATM");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	static void save() {
		System.out.println("请输入存款金额：");
		int money = scanner.nextInt();
		acct.balance += money;
		System.out.println("存款成功,余额：" + acct.balance);

	}

	static void withdraw() {
		System.out.println("请输入取款金额：");
		int money = scanner.nextInt();
		if (money > acct.balance) {
			System.out.println("余额不足，余额：" + acct.balance);
			return;
		}

		acct.balance -= money;
		System.out.println("取款成功,余额：" + acct.balance);
	}

}
