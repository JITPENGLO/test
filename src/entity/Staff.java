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
public class Staff {
    private String staffID;
    private String staffName;
    private String staffType;
    private String contact;
    private String staffPass;

    public Staff() {
    }
    
    public Staff(String staffID, String staffName, String staffType, String contact, String staffPass) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffType = staffType;
        this.contact = contact;
        this.staffPass = staffPass;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStaffPass() {
        return staffPass;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass;
    }

    @Override
    public String toString() {
        return "\nStaff ID: " + staffID + 
               "\nStaff Name: " + staffName +
               "\nStaff Type: " + staffType + 
               "\nContact: " + contact + 
               "\nStaff Password: " + staffPass;
    }
    
}
