/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author asus
 */
public class ProductLList<T> implements ProductListInterface<T> {
    
    private Node firstNode;
    private int numberOfEntries;
    
    public ProductLList() {
    clear();
  }

  public final void clear() {
    firstNode = null;
    numberOfEntries = 0;
  }

  public boolean addProd(T newEntry) {
    Node newNode = new Node(newEntry);

    if (isEmpty()) {
      firstNode = newNode;
    } else {
      Node lastNode = getNodeAt(numberOfEntries);
      lastNode.next = newNode;
    }

    numberOfEntries++;
    return true;
  }

  public boolean addProd(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
        newNode.next = firstNode;
        firstNode = newNode;
      } else {								                      // case 2: list is not empty and newPosition > 1
        Node nodeBefore = getNodeAt(newPosition - 1);
        Node nodeAfter = nodeBefore.next;
        newNode.next = nodeAfter;
        nodeBefore.next = newNode;
      }

      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T removeProd(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      if (givenPosition == 1) {      // case 1: remove first entry
        result = firstNode.data;     // save entry to be removed 
        firstNode = firstNode.next;
      } else {                         // case 2: givenPosition > 1
        Node nodeBefore = getNodeAt(givenPosition - 1);
        Node nodeToRemove = nodeBefore.next;
        Node nodeAfter = nodeToRemove.next;
        nodeBefore.next = nodeAfter; // disconnect the node to be removed
        result = nodeToRemove.data;  // save entry to be removed
      }

      numberOfEntries--;
    }

    return result;
  }

  public boolean replaceProd(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node desiredNode = getNodeAt(givenPosition);
      desiredNode.data = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      result = getNodeAt(givenPosition).data;
    }

    return result;
  }
  
  public T getLastItem(){
      T item = null;
      if(!isEmpty()){
      Node currentNode = firstNode;
      while(currentNode.next != null){
          currentNode = currentNode.next;
      }
      item = currentNode.data;
      }
      return item;
  }

  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  
  public boolean isEmpty() {
    boolean result;

    if (numberOfEntries == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }

  public boolean isFull() {
    return false;
  }


  /**
   * Task: Returns a reference to the node at a given position. Precondition:
   * List is not empty; 1 <= givenPosition <= numberOfEntries.
   */
  private Node getNodeAt(int givenPosition) {
        Node currentNode = firstNode;

    // traverse the list to locate the desired node
    for (int counter = 1; counter < givenPosition; counter++) {
      currentNode = currentNode.next;
    }

    return currentNode;
  }
  
    public class Node {

    private T data; // entry in list
    private Node next; // link to next node

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
  }
}
