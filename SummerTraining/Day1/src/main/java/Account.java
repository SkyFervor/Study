public class Account {
	String cardId;
	String password;
	double balance;
	String realName;
	String bankName;

	Account(String cardId, String password, double balance, String realName,
			String bankName) {
		super();
		this.cardId = cardId;
		this.password = password;
		this.balance = balance;
		this.realName = realName;
		this.bankName = bankName;
	}
}
