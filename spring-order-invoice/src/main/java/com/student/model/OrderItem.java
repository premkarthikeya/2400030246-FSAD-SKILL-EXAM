package com.student.model;

public class OrderItem {

    private String product;
    private int qty;
    private double price;

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public double lineTotal() {
        return qty * price;
    }
}