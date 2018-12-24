/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author User
 */
public interface ManageOrderInterface<T> {
    public T getEntry(int givenPosition); // Get the PickUp and Delivery Order from 
    public boolean replace(int givenPosition, T newEntry);// replace the pickup and delivery order status
    public boolean isEmpty();
    public int size();
}
