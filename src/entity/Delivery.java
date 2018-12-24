/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;


/**
 *
 * @author User
 */
public class Delivery extends ProductOrder{
    private String address;
    private int postCode;
    private String city;
    private String date;

    public Delivery() {
    }

    public Delivery(String address, int postCode, String city, String date) {
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.date = date;
    }

//    public Delivery(String address, int postCode, String city, String orderID, double totalPrice, Product productID, Customer customerID){
//        super(orderID, totalPrice, productID, customerID);
//        this.address = address;
//        this.postCode = postCode;
//        this.city = city;
//    }
    
    public Delivery(String orderID, Product product, int quantity, double totalPrice, Customer customerID, String status, String address, int postCode, String city, String date ) {
        super(orderID, product, quantity, totalPrice, customerID, status);
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.date = date;
    }
    
    public String getAddress() {
        return address;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
