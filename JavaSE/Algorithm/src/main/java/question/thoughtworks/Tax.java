package question.thoughtworks;

import java.math.BigDecimal;

/**
 * Tax calculator
 */
public class Tax {
	public static final double BASIC_RATE = 0.1; // 基本税率
	public static final String[] BASIC_EXEMPT = { "book", "chocolate", "pill" }; // 免税类别
	public static final double IMPORTED_RATE = 0.05; // 进口税率

	public static BigDecimal calculateTax(Goods goods) {
		String description = goods.getDescription();
		double totalRate = BASIC_RATE; // goods应缴的总税率

		// 判断是否免税
		for (String s : BASIC_EXEMPT) {
			if (description.indexOf(s) != -1) {
				totalRate = 0.0;
				break;
			}
		}

		// 判断是否进口
		if (description.indexOf("imported") != -1)
			totalRate += IMPORTED_RATE;

		// 计算税额
		return multiplyWithRoundRule(goods.getPrice(), new BigDecimal(totalRate));
	}

	// BigDecimal乘法运算,保留两位小数并按指定的舍入规则处理结果
	// 规则：不足0.05的部分入到下一个0.05(7.12->7.15, 7.10->7.10)
	// 方法：对结果乘2, 0.05*2=0.1, 按0.1上入, 再除以2即可
	public static BigDecimal multiplyWithRoundRule(BigDecimal a, BigDecimal b) {
		BigDecimal _2b = b.multiply(new BigDecimal(2));
		BigDecimal _2ab = a.multiply(_2b).setScale(2, BigDecimal.ROUND_DOWN)
				.setScale(1, BigDecimal.ROUND_UP);
		BigDecimal _ab = _2ab.divide(new BigDecimal(2)).setScale(2);
		return _ab;
	}
}
