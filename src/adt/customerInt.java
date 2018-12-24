/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author user
 */
public interface customerInt<T> {
    public void register(T data);
    public T getAt(int index);
    public boolean updateCreditLimit(T oldData,T newData);
    public int getLength();
    public boolean isEmpty();
    public String toString();
    
}
