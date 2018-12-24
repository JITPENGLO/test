/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author User
 */
public class ProductOrder {
    private String orderID;
    private int quantity;
    private double totalPrice;
    private Product product;
    private Customer customerID;
    private String status;

    public ProductOrder() {
    }

    public ProductOrder(String orderID, Product product, int quantity, double totalPrice, Customer customerID, String status) {
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.customerID = customerID;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomerID() {
        return customerID;
    }
    
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
