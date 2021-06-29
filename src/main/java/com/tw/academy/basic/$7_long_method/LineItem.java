package com.tw.academy.basic.$7_long_method;

public class LineItem {
	public static final char CHAR_TAB = '\t';
	public static final char CHAR_NEW_LINE = '\n';
	public static final double TAX_RATE_10 = .10;

	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double p, int quantity) {
		super();
		this.description = description;
		this.price = p;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double getAmount() {
        return price * quantity;
    }

	public StringBuilder getLineItemString() {
		StringBuilder receiptContentItem = new StringBuilder();
		receiptContentItem.append(this.getDescription());
		receiptContentItem.append(CHAR_TAB);
		receiptContentItem.append(this.getPrice());
		receiptContentItem.append(CHAR_TAB);
		receiptContentItem.append(this.getQuantity());
		receiptContentItem.append(CHAR_TAB);
		receiptContentItem.append(this.getAmount());
		receiptContentItem.append(CHAR_NEW_LINE);
		return receiptContentItem;
	}

	public double getSalesTax() {
		return this.getAmount() * TAX_RATE_10;
	}
}
