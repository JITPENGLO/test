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
public class SalesOrder {
    public String id;
    public String desc;
    public String status;
    public String date;
    public String time;
    public int quantity;
    public double price;
    public CorporateCustomer corCust;
    
    public SalesOrder(String id, String desc, String date, String time,int quantity, double price, String status,CorporateCustomer corCust){
        this.id = id;
        this.desc = desc;
        this.date = date;
        this.time = time;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.corCust = corCust;
    }

    public CorporateCustomer getCorCust() {
        return corCust;
    }

    public void setCorCust(CorporateCustomer corCust) {
        this.corCust = corCust;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
