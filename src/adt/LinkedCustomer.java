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
public class LinkedCustomer<T> implements customerInt<T> {
    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    public LinkedCustomer() {
        firstNode = null;
        size =0;
    }
    
    public void register(T data){
        Node newNode = new Node(data);
        
        if(isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
        }
        else{
            lastNode.next = newNode;
            lastNode = newNode;
        }
        size++;
    }
    
    public T getAt(int index){
        T item = null;
        Node currentNode = firstNode;
        if(!isEmpty()){
            while(index != 0 && index < size){
                currentNode = currentNode.next;
                index--;
            }
            item = currentNode.data;
        }
        return item;
    }
    
    public boolean updateCreditLimit(T oldData,T newData){
        boolean update = false;
        if(!isEmpty()){
            Node currentNode = firstNode;
            for(int i=0;i<size;i++){
                if(currentNode.data.equals(oldData)){
                    currentNode.data = newData;
                    update = true;
                }
                else{
                    currentNode = currentNode.next;
                }
            }
        }
        return update;
    }
    
    public int getLength(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public String toString(){
        String str = "";
        Node currentNode = firstNode;
        for(int i=0;i<size;i++){
            str += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return str;
    }
    
    public class Node{
        private T data;
        private Node next;
        
        public Node(T data){
            this.data = data;
        }
    }
    
}
