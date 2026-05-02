package com.student.model;

import java.util.List;

public class Order {

    private String orderId;
    private String customerName;
    private double discountRate; // %
    private List<OrderItem> items;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void printInvoice() {

        System.out.println("Order: " + orderId + " | Customer: " + customerName);
        System.out.println("---------------------------------");

        double total = 0;

        for (OrderItem it : items) {
            double line = it.lineTotal();
            total += line;
            System.out.println(it.getProduct() + " x" + it.getQty() +
                    " @" + it.getPrice() + " = " + line);
        }

        double discount = total * (discountRate / 100.0);

        System.out.println("---------------------------------");
        System.out.println("Total: " + total);
        System.out.println("Discount (" + discountRate + "%): " + discount);
        System.out.println("Payable: " + (total - discount));
    }
}