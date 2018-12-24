package adt;

public class LinkedStaff<T> implements staffInt<T> {
    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    public LinkedStaff() {
        firstNode = null;
        size =0;
    }
    
    public void addNew(T data){
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
