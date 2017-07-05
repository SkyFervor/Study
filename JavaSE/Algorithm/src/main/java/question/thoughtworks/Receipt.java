package question.thoughtworks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class
 */
public class Receipt {
	private List<Goods> list = new ArrayList<>(); // 商品列表
	private BigDecimal taxes = new BigDecimal(0); // 总税额
	private BigDecimal total = new BigDecimal(0); // 总金额

	// 程序入口
	public static void main(String[] args) throws Exception {
		Receipt r = new Receipt();
		r.input();
		r.calculate();
		r.output();
	}

	// 输入
	private void input() throws Exception {
		Scanner scanner = new Scanner(System.in);
		try {
			while (scanner.hasNextLine()) {
				String info = scanner.nextLine();
				if (info.isEmpty() || info.equals("0"))
					break;

				// 根据描述信息，创建对应的Goods对象，并放入list
				int i = info.indexOf(" ");
				int j = info.lastIndexOf(" ");

				int amount = Integer.parseInt(info.substring(0, i));
				String description = info.substring(i + 1, j - 3);
				BigDecimal price = new BigDecimal(info.substring(j + 1));

				Goods goods = new Goods(amount, description, price);
				list.add(goods);
			}
		} catch (Exception e) {
			throw new Exception("Information error, please check the input");
		} finally {
			scanner.close();
		}
	}

	// 计算税额
	private void calculate() {
		for (Goods goods : list) {
			BigDecimal tax = Tax.calculateTax(goods); // 计算每个商品的税额

			goods.setPrice(goods.getPrice().add(tax)); // 更新商品价格
			taxes = taxes.add(tax); // 更新总税额
			total = total.add(goods.getPrice()); // 更新总金额
		}
	}

	// 输出
	private void output() {
		for (Goods goods : list) {
			System.out.print(goods.getAmount() + " ");
			System.out.print(goods.getDescription() + ": ");
			System.out.println(goods.getPrice());
		}
		System.out.println("Sales Taxes: " + taxes);
		System.out.println("Total: " + total);
	}
}
