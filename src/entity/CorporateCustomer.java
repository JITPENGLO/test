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
public class CorporateCustomer extends Customer{
    private String companyID;
    private String companyName;
    private double creditLimit;
    private String email;
    private double remainLimit;

    public CorporateCustomer() {
        
    }

    public CorporateCustomer(String companyID,String companyName, double creditLimit, String email,double remainLimit) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.creditLimit = creditLimit;
        this.email = email;
        this.remainLimit = remainLimit;
    }
    
    public CorporateCustomer(String custID, String custName, String contactNo, 
                                String password, String companyID, String companyName,
                                double creditLimit, String email,double remainLimit) {
        super(custID, custName, contactNo, password);
        this.companyID = companyID;
        this.companyName = companyName;
        this.creditLimit = creditLimit;
        this.email = email;
        this.remainLimit =remainLimit;
    }

    public String getCompanyID() {
        return companyID;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public double getRemainLimit(){
        return remainLimit;
    }
    
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setRemainLimit(double remainLimit){
        this.remainLimit = remainLimit;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nCompany ID: " + companyID + 
               "\nCompany Name: " + companyName + 
               "\nCredit Limit: " + creditLimit + 
               "\nEmail: " + email +
               "\nRemain Credit Limit: " + remainLimit;
    }

    
    
}
