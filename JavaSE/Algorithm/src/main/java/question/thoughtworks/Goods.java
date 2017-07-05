package question.thoughtworks;

import java.math.BigDecimal;

/**
 * POJO of goods
 */
public class Goods {
	private int amount; // 数量
	private String description; // 其余描述
	private BigDecimal price; // 价格

	// Constructor
	public Goods(int amount, String description, BigDecimal price) {
		this.amount = amount;
		this.description = description;
		this.price = price;
	}

	// Getters and Setters
	public int getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
