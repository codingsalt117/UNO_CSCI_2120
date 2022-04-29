/**
*@author: Robin Johnson
*@version: 1.0
*LinkedList: Contains all methods for handling a LinkedList 
*/

import java.util.*;

public class LinkedList<T>  {

    Node itsFirstNode;
    Node itsLastNode;
    private int size;

    /**
     * Class Constructor
     * <p>
     * Creates the basic elements needed for a doubly linkedlist
     */
    public LinkedList() {
        itsFirstNode = null;
        itsLastNode = null;
        size = 0;
    }

    /**
     * Method Size
     * <p>
     * Returns size of list
     */
    public int size() {
        return this.size;
    }
    /**
     * Method getIterator
     * <p>
     * Returns an iterator for current list
     */
    public Iterator<T> getIterator() {
        return new Iterator<T>(this);
    }

    /**
     * Method Add
     * <p>
     * Adds a element to the end of the list
     * @param T element
     */
    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element) { 
        Node node = new Node(element);

        if (itsFirstNode == null) {
            itsFirstNode = node;
            itsLastNode = node;
        }

        else {
            //Setting nodes to correct .next and .prior in respect to the new node
            //itsLastNode.setNextNode(node);
            node.setPriorNode(itsLastNode);
            itsLastNode.setNextNode(node);
            itsLastNode = node;
            
        }
        //Adding a new node increases size
        size++;
    }

    /**
     * Method add(overidden)
     * <p>
     * Adds a element at a specified index
     * @param T element
     * @param int index
     */
    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element, int index) {
       //making sure index passed is not an invalid indice
        if(index >= 0 && index <= size){
            // add at first index, creating a new node
            if(index == 0) {
                Node newNode = new Node(element);
                //Setting nodes to correct .next and .prior in respect to the new node
                newNode.setNextNode(itsFirstNode);
                itsFirstNode.setPriorNode(newNode);
                itsFirstNode = newNode; 
                
                // if the list is empty
                if(itsLastNode == null){
                itsLastNode = itsFirstNode;
                } 
                
                //Adding elements increases size
                size++; 
            }
            // Add at the end if the index is the same as the size of list
            else if(index == size){
                add(element);
            } 
               
            // adding anywhere not the beginning or end, create a new node
            else { 
                Node newNode = new Node(element);
                Node current = itsFirstNode; // set current to first node
              
                // looping gets the node before which is where the newNode will be added in at
                while(index > 0){
                   current = current.getNextNode();
                   index--;
                }
              
                //Setting nodes to correct .next and .prior in respect to the new node
                newNode.setNextNode(current);
                newNode.setPriorNode(current.getPriorNode());
                current.getPriorNode().setNextNode(newNode);
                current.setPriorNode(newNode);                  
                //Adding elements increases size
                size++; 
           }
       }
      
    }

    /**
     * Method Get
     * <p>
     * Returns the data in a node via index
     * @param int index
     */
    public T get(int index) {
        int counter = 0;
        Node current = itsFirstNode;
        //if not at the an empty index
        while (current != null /* && counter < size */ ) {
            //if at the correct index
            if (counter == index){
                break;
            }
           
            current = current.getNextNode();
            counter++;
        }
        
        return current.getData();
    }

    /**
     * Method Contains
     * Returns a boolean response if a passed element is within list
     * @param <T> element 
     */
    // TO BE IMPLEMENTED
    // returns true if element is in the list, false if not
    public boolean contains(T element) {
        Node current = itsFirstNode;
        boolean found = false;

        if(size == 0) { 
            throw new IllegalStateException("List");
        }

        while(current != null && !found){
            if(element.equals(current.getData())){
                found = true;
            }

            else{
                current = current.getNextNode();
            }
        }
        return found;
    }

    /**
     * Method indexOf
     * <p>
     * returns the index of the element if it is in the list, -1 if not found
     * @param T element
     */
    // returns the index of the element if it is in the list, -1 if not found
    public int indexOf(T element) {
        Iterator<T> iteratorA = new Iterator<T>(this);
        int index = 0;

        while(iteratorA.hasNext()){
            if(element.equals(iteratorA.next())){
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Method iteratorAt
     * <p>
     * returns an Iterator at the location of the element if it is in the list
     * <p>
     * returns the null reference if the element is not found
     * @param T element
     */
    // returns an Iterator at the location of the element if it is in the list
    // returns the null reference if the element is not found
    public Iterator<T> iteratorAt(T element) {
        Iterator<T> iteratorB = new Iterator<T>(this);

        while(iteratorB.hasNext()){
            if(iteratorB.next() == element){
                return iteratorB;
            }
        }
        return null;
    }

    /**
     * Method getFirst
     * <p>
     * returns itsFirstNode 
     */
    public Node getFirst(){
        return itsFirstNode;
    }

    /**
     * Method getLast
     * <p>
     * returns itsLastNode
     */
    public Node getLast(){
        return itsLastNode;
    }    

    /**
     * Method toString
     * <p>
     * Returns a string representation of a node
     */
    public String toString() {
        String returnVal = "";
        Node current = itsFirstNode;
        if (size != 0 ) {
            while (current != null ) {
                returnVal += current.toString();
                returnVal += "\n";
                current = current.getNextNode();
            }
        }
        return returnVal;
    }  // end toString

    /**
     * Inner Class Node
     * <p>
     * Class purpose is to generate nodes for LinkedList. Each node has a (knows its) next node, prior node and its data
     * @param T Data
     */
    class Node {
    
        private T data;
        private Node itsNext;
        private Node itsPrior;
    
        public Node(T data) {
            itsNext = null;
            itsPrior = null;
            this.data = data;
        }
    
    
        public T getData() {
            return this.data;
        }
    
        public Node getNextNode() {
            return itsNext;
        }

        // TO BE IMPLEMENTED
        public Node getPriorNode() {
            return itsPrior;
        }
    
        public void setNextNode(Node next) {
            itsNext = next;
        }

        // TO BE IMPLEMENTED
        public void setPriorNode(Node prior) {
            itsPrior = prior;
        }
        
    
        public String toString() {
            return data.toString();
        }
    
    }  // end of Node
}
