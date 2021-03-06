package com.tw.academy.basic.$7_long_method;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public StringBuilder getOrderReceiptContent() {
        StringBuilder orderReceiptContent = new StringBuilder();
        if (lineItems == null) {
            return orderReceiptContent;
        }
        lineItems.forEach(lineItem -> {
            orderReceiptContent.append(lineItem.getLineItemString());
        });
        return orderReceiptContent;
    }

    public double getTotalSalesTx() {
        if (lineItems == null) {
            return 0.0;
        }
        return lineItems.stream().mapToDouble(LineItem::getSalesTax).sum();
    }

    public double getTotalPrice() {
        if (lineItems == null) {
            return 0.0;
        }
        return lineItems.stream().mapToDouble(lineItem -> lineItem.getAmount() + lineItem.getSalesTax()).sum();
    }
}
