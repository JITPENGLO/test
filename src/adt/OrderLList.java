package adt;

/**
 * OrderLList.java A class that implements the ADT list by using a chain of nodes,
 with the node implemented as an inner class.
 */
public class OrderLList<T> implements OrderInterface<T> {

  private Node firstNode;                               // reference to first node
  private int numberOfEntries;                          // number of entries in list

  public OrderLList() {

  }

  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);                  // create the new node

    if (isEmpty()){
      firstNode = newNode;
    } 
    else {                                            // add to end of nonempty list
      Node currentNode = firstNode;			// traverse linked list with p pointing to the current node
      while (currentNode.next != null) {		// while have not reached the last node
        currentNode = currentNode.next;
      }
      currentNode.next = newNode;                       // make last node reference new node
    }

    numberOfEntries++;
    return true;
  }

  @Override
  public T remove(int givenPosition) {
    T result = null;                                    // return value

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      if (givenPosition == 1) {                         // case 1: remove first entry
        result = firstNode.data;                        // save entry to be removed
        firstNode = firstNode.next;
      } 
      else {                                          // case 2: givenPosition > 1
        Node nodeBefore = firstNode;
        for (int i = 1; i < givenPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;                 // advance nodeBefore to its next node
        }
        result = nodeBefore.next.data;                  // save entry to be removed
        nodeBefore.next = nodeBefore.next.next;         // make node before point to node after the
      } 																// one to be deleted (to disconnect node from chain)

      numberOfEntries--;
    }

    return result;                                      // return removed entry, or
    // null if operation fails
  }

  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;                 // advance currentNode to next node
      }
      result = currentNode.data;                        // currentNode is pointing to the node at givenPosition
    }

    return result;                                      // return the current use data
  }

  @Override
  public int getNumberOfEntries() {
    return numberOfEntries;                             // return the total number of entries on that list
  }

  @Override
  public boolean isEmpty() {
    boolean result;

    result = numberOfEntries == 0;                      // set the total number of entries to zero to assume the list is empty

    return result;                                      // return empty result
  }

  private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }                                                         // end Node

}                                                           // end OrderLList
