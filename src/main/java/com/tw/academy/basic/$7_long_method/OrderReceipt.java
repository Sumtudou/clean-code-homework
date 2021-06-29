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

        double totSalesTx = 0d;
        double totalPrice = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receiptContent.append(lineItem.getLineItemString());
            double salesTax = lineItem.getSalesTax();
            totSalesTx += salesTax;
            totalPrice += lineItem.getAmount() + salesTax;
        }

        receiptContent.append(STRING_SALES_TAX).append(CHAR_TAB).append(totSalesTx);
        receiptContent.append(STRING_TOTAL_AMOUNT).append(CHAR_TAB).append(totalPrice);
        return receiptContent.toString();
    }
}
