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
public class Customer {
    private String custID;
    private String custName;
    private String contactNo;
    private String password;

    public Customer() {
    }

    public Customer(String custID, String password) {
        this.custID = custID;
        this.password = password;
    }

    public Customer(String custID, String custName, String contactNo, String password) {
        this.custID = custID;
        this.custName = custName;
        this.contactNo = contactNo;
        this.password = password;
    }

    public String getCustID() {
        return custID;
    }

    public String getCustName() {
        return custName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nCustomer ID: " + custID + 
               "\nCustomer Name: " + custName + 
               "\nContact No: " + contactNo + 
               "\nPassword: " + password;
    }
    
}
