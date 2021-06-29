package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt extends constant {

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String generateReceipt() {
        StringBuilder receiptContent = new StringBuilder();

        receiptContent.append(RECEIPT_HEADER);
        receiptContent.append(order.getCustomerName());
        receiptContent.append(order.getCustomerAddress());

        receiptContent.append(order.getOrderReceiptContent());

        double totSalesTx = order.getTotalSalesTx();
        double totalPrice = order.getTotalPrice();
        receiptContent.append(STRING_SALES_TAX).append(CHAR_TAB).append(totSalesTx);
        receiptContent.append(STRING_TOTAL_AMOUNT).append(CHAR_TAB).append(totalPrice);
        return receiptContent.toString();
    }
}
