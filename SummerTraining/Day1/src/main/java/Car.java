public class Car {
	String brand; // 品牌
	int price; // 价格

	void drive() {
		System.out.println("Car is running");
		System.out.println("---------------------------->");
	}

	public static void main(String[] args) {
		Car c = new Car();
		c.brand = "兰博基尼";
		c.price = 20000000;
		c.drive();
	}

}
