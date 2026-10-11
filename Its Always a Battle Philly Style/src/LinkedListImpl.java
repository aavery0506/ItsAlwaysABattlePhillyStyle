/******
 Name: Alison Avery
 Assignment: Lab 4 Task List
 Fall 2023
 Notes: LinkedListImpl Class
 ******/
import java.util.function.Function;
import java.util.function.Predicate;


public class LinkedListImpl<T> implements LinkedListADT<T> {

    private Node<T> head;

    public LinkedListImpl() {
        this.head = new EmptyNode<T>();
    }

    LinkedListImpl(Node<T> node) {
        this.head = new ElementNode<T>((T) node);
    }


    /**addFront method adds an Object to the front of the list
     * @param object the object that will be added to the list
     */
    @Override
    public void addFront(Object object) {
        this.head = this.head.addFront((T) object);
    }

    /** addBack method adds an object to the back of the list
     * @param object the object that will be added to the list
     */
    @Override
    public void addBack(Object object) {
        this.head = this.head.addBack((T) object);
    }

    /** add method adds an object at a specified index of the list
     * @param index the index where the object should be added
     * @param object the object to be added to the list
     */
    @Override
    public void add(int index, Object object) {
        this.head = this.head.add(index, (T) object);

    }

    /** getSize method returns the size of the list
     * @return returns the size of the list
     */
    @Override
    public int getSize() {
        return this.head.count();
    }
    public  int getSize(Predicate <T> predicate){
        return this.head.count(predicate);
    }

    /**remove method removes the specified object from the list
     * @param object the object to be removed from the list
     */
    @Override
    public void remove(Object object) {
        //this.head = this.head.remove((T) object);
        Node<T> temp = this.head.remove((T) object);
        if(temp != null){
            this.head=temp;
        }
    }
    public void remove(Predicate <T> predicate) {
        Node<T> temp = this.head.remove(predicate);
        if(temp != null){
            this.head=temp;
        }
    }
    /**
     * removeAll method returns an empty list
     * @return returns a new empty list
     */
    public void removeAll() {
        this.head = new EmptyNode<T>();
    }


    /**
     * get method gets the object of a specific index of the list
     * @param index what index to retrieve the object from
     * @return the object from the specified index
     * @throws IllegalArgumentException if the provided index is out of bounds
     */

    public T get(int index)throws IllegalArgumentException {
        if ((index >= 0) && (index < getSize())) {
            return head.get(index);
        } else {
            throw new IllegalArgumentException("Invalid index");
        }
    }


    /**
     * filter method takes in a predicate and filters the list by that predicate
     *
     * @param predicate what the list should be filtered by
     * @return new filtered list
     */

    public LinkedListImpl<T> filter(Predicate<T> predicate) {
        return new LinkedListImpl<T>(this.head.filter(predicate));
    }
    public LinkedListImpl<T> print(Predicate <T> predicate){
        return new LinkedListImpl<T>(head.filter(predicate));
    }

    public <R> LinkedListADT<R> map(Function<T,R> converter) {
        return new LinkedListImpl<R>(head.map(converter));
    }

    public String toString() {
        if (this.head == null){
            return "Empty list!";
        }
        else {
            return "(" + this.head.toString() + ")";
        }
    }


}