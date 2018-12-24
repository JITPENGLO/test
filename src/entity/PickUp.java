/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author User
 */
public class PickUp extends ProductOrder{
    private String date;
    private String time;
    private String timeStamp;
    
    public PickUp() {
    }

    public PickUp(String date, String time, String timeStamp ) {
        this.date = date;
        this.time = time;
        this.timeStamp = timeStamp;
        
    }
    
    public PickUp(String orderID, Product productID, int quantity, double totalPrice, Customer customerID,String status, String date, String time) {
        super(orderID, productID, quantity, totalPrice, customerID, status);
        this.date = date;
        this.time = time;
    }

    public PickUp(String timeStamp, String date, String time, String orderID,int quantity, double totalPrice, Product productID, Customer customerID, String status) {
        super(orderID, productID, quantity, totalPrice, customerID, status);
        this.timeStamp = timeStamp;
        this.date = date;
        this.time = time;
    }

   
    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
