/**
 * @author Robin Johnson
 * @version 1.0
 * 
 * Iterator used for returning element from a collection
 */
public class Iterator<T> {

    // Need two LinkedList objects to be made, a list and a corrisponding node
    private LinkedList<T> myList;
    private LinkedList<T>.Node myCurrentNode;

    /**
     * Constructor Iterator
     * <p>
     * Constructor Iterator constructs an iterator for a list
     */
    public Iterator(LinkedList<T> list) {
        myList = list;
        myCurrentNode =  myList.itsFirstNode;
    }

    /**
     * Method hasNext
     * <p>
     * Returns a boolean result, does the calling node have a next node.
     */
    // return true if there is a "next" element, otherwise returns false
    public boolean hasNext() {
        // Condition checking if it from empty list and its in a list of > 1
        if (myCurrentNode != null){
            if(myList.getFirst() != null)
                return true;
        }

        else{
           return false;
        }
        //Checking condition specifically for if the list is = 1
        if (myCurrentNode.getNextNode() == null ){
            return false;
        }
        // covers all conditions of having nextNode if none of the previous checks fit
        else{
            return true;
        }

    }

    /**
     * Method hasPrior
     * <p>
     *  Returns a boolean result, does the calling node have a prior/previous node.
     */    
    // TO BE IMPLEMENTED
    // return true if there is a "prior" element, otherwise returns false
    public boolean hasPrior() {
        //Condition checking if it from empty lis
        if (myCurrentNode != null){
            return true;
        }
        return false;

    }

    /**
     * Method next
     * <p>
     * Returns rhw "next" node
     */
    // returns the "next" node (really the current one) and
    // moves the Iterator forward by one node
    public T next() {
        T data = myCurrentNode.getData();
        myCurrentNode = myCurrentNode.getNextNode();
        return data;
    }

    /**
     * Method prior
     * <p>
     * Returns the "prior" node
     */
    // TO BE IMPLEMENTED
    // returns the "prior" node (really the current one) and
    // moves the Iterator backward by one node
    public T prior() {
        T data = myCurrentNode.getData();
        myCurrentNode = myCurrentNode.getPriorNode();
        return data;

    }

    /**
     * Method setToEnd
     * <p>
     * Points the iterator to the "last" node
     */
    // TO BE IMPLEMENTED
    // Sets this iterator to point to the last Node in the list
    public void setToEnd() {
        myCurrentNode = myList.getLast();
    }

    /**
     * Method setToBeg
     * <p>
     * Points the iterator to the "first" node
     */
    // Sets this iterator to point to the last Node in the list
    public void setToBeg() {
        myCurrentNode = myList.getFirst();
    }

}

