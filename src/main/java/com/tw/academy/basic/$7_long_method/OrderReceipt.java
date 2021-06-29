package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final String RECEIPT_HEADER = "======Printing Orders======\n";
    public static final char CHAR_TAB = '\t';
    public static final char CHAR_NEW_LINE = '\n';
    public static final String STRING_SALES_TAX = "Sales Tax";
    public static final String STRING_TOTAL_AMOUNT = "Total Amount";
    public static final double TAX_RATE_10 = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String generateReceipt() {
        StringBuilder receiptContent = new StringBuilder();

        receiptContent.append(RECEIPT_HEADER);
        receiptContent.append(order.getCustomerName());
        receiptContent.append(order.getCustomerAddress());

        double totSalesTx = 0d;
        double totalPrice = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            getLineItemString(receiptContent, lineItem);
            double salesTax = getSalesTax(lineItem);
            totSalesTx += salesTax;
            totalPrice += lineItem.getAmount() + salesTax;
        }

        receiptContent.append(STRING_SALES_TAX).append(CHAR_TAB).append(totSalesTx);
        receiptContent.append(STRING_TOTAL_AMOUNT).append(CHAR_TAB).append(totalPrice);
        return receiptContent.toString();
    }

    private double getSalesTax(LineItem lineItem) {
        return lineItem.getAmount() * TAX_RATE_10;
    }

    private void getLineItemString(StringBuilder receiptContent, LineItem lineItem) {
        receiptContent.append(lineItem.getDescription());
        receiptContent.append(CHAR_TAB);
        receiptContent.append(lineItem.getPrice());
        receiptContent.append(CHAR_TAB);
        receiptContent.append(lineItem.getQuantity());
        receiptContent.append(CHAR_TAB);
        receiptContent.append(lineItem.getAmount());
        receiptContent.append(CHAR_NEW_LINE);
    }
}
