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

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(RECEIPT_HEADER);

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append(CHAR_TAB);
            output.append(lineItem.getPrice());
            output.append(CHAR_TAB);
            output.append(lineItem.getQuantity());
            output.append(CHAR_TAB);
            output.append(lineItem.totalAmount());
            output.append(CHAR_NEW_LINE);

            double salesTax = lineItem.totalAmount() * TAX_RATE_10;
            totSalesTx += salesTax;

            tot += lineItem.totalAmount() + salesTax;
        }

        output.append(STRING_SALES_TAX).append(CHAR_TAB).append(totSalesTx);

        output.append(STRING_TOTAL_AMOUNT).append(CHAR_TAB).append(tot);
        return output.toString();
    }
}
