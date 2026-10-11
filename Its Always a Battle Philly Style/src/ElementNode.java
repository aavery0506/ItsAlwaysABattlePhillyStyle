
import java.util.function.Function;
import java.util.function.Predicate;
public class ElementNode<T>  implements Node <T> {
    private final T data;
    private Node<T> nextNode;

    /**
     * Basic constructor for an ElementNode.
     * Accepts generic data for the Node to hold.
     * Sets nextNode to an EmptyNode of the same type.
     *
     * @param data Generic data to be set to the Node.
     */
    public ElementNode(T data) {
        this.data = data;
        this.nextNode = new EmptyNode<T>();
    }

    /**
     * Constructor for an ElementNode.
     * Accepts the Node for the nextNode and data for creating the current Node.
     *
     * @param nextNode sets the nextNode to the Node passed to the Constructor
     * @param data     data to be set to the Node
     */
    public ElementNode(Node<T> nextNode, T data) {
        this.data = data;
        this.nextNode = nextNode;
    }

    /**
     * Count method recursively counts the number of Nodes in the List
     *
     * @return an int of the count of Nodes in the list
     */
    @Override
    public int count() {
        return 1 + this.nextNode.count();
    }

    public int count(Predicate<T> predicate) {
        if (predicate.test(this.data)) {
            return 1 + this.nextNode.count(predicate);
        }
        return this.nextNode.count(predicate);
    }

    /**
     * Adds a new Node to the front of the list
     *
     * @param object Generic Node object to be added to the List
     * @return new ElementNode with the new ElementNode and the rest of the list
     */
    @Override
    public Node<T> addFront(T object) {
        return new ElementNode<T>((Node<T>) object, (T) this);
    }

    /**
     * Adds a new Node to the back of the list
     *
     * @param object Generic Node object to be added to the List
     * @return new ElementNode with the new ElementNode and the rest of the list
     */
    @Override
    public Node<T> addBack(T object) {
        this.nextNode = this.nextNode.addBack(object);
        return this;
    }

    /**
     * add method adds a Node to a specific index of the list
     *
     * @param index  the index that the object should be added to
     * @param object the object to be added to the list
     * @return a new list with the added object
     * @throws IllegalArgumentException if the index is less than 0 or greater than the count of the list
     */
    @Override
    public Node<T> add(int index, T object) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("index must be greater or equal to 0");
        } else if (index == 0) {
            return addFront(object);
        } else if (index > this.count()) {
            throw new IllegalArgumentException("Invalid index value");
        } else {
            this.nextNode = this.nextNode.add(index - 1, object);
            return this;
        }
    }

    /**
     * remove function removes a specified object from the list.
     *
     * @param object the object to be removed from the list
     * @return the rest of the list without the object
     */
    @Override
    public Node<T> remove(T object) {
        //head becomes nextNode
        if (this.data.equals(object)) {
            return this.nextNode;
        } else {
            this.nextNode = this.nextNode.remove(object);
            //return this.nextNode;
            //list nodes relinked, headNode should not be reassigned
            return null;
        }
    }

    @Override
    public Node<T> remove(Predicate<T> predicate) {
        //Task tempTask = (Task)this.data;
        if (predicate.test(this.data)) {
            this.nextNode.remove(predicate);
            return this.nextNode;
        } else {
            this.nextNode = this.nextNode.remove(predicate);
            return null;
        }
    }

    /**
     * filters a list by the given Predicate
     *
     * @param predicate Predicate to filter by
     * @return the filtered Nodes
     */
    @Override
    public Node<T> filter(Predicate<T> predicate) {
        if (predicate.test(this.data)) {
            return new ElementNode(this.nextNode.filter(predicate));
        } else {
            return nextNode.filter(predicate);
        }
    }

    /**
     * Sorts the list by a given predicate
     *
     * @param predicate Predicate to be sorted by
     * @return sorted list of Nodes
     */
    @Override
    public Node sort(Predicate predicate) {
        return this.nextNode.sort(predicate).insertNode(predicate, this.data);
    }

    /**
     * used in sort method to insert Nodes in the correct order
     *
     * @param p    predicate passed by sort method
     * @param data the data in the Node
     * @return new Element Node
     */
    @Override
    public Node insertNode(Predicate predicate, T data) {
        if (!(nextNode instanceof EmptyNode)) {
            return new ElementNode(nextNode, data);
        } else {
            return new ElementNode(this, data);
        }
    }

    /**
     * @param index
     * @return
     */
    @Override
    public T get(int index) throws IllegalArgumentException {
        if (index == 0) return this.data;
        return this.nextNode.get(index - 1);
    }

    /**
     * Gets the string representation of the List
     *
     * @return String representation of the list
     */
    @Override
    public String getString() {
        return data.toString() + " " + nextNode.getString();
    }

    /**
     * @param predicate
     * @param index
     * @param data
     * @return
     */
    @Override
    public Node insertNode(Predicate predicate, int index, T data) {
        return null;
    }

    /**
     * @param predicate
     * @param data
     * @return
     */
    @Override
    public Node insert(Predicate predicate, T data) {
        return null;
    }

    /**
     * @param converter
     * @param <R>
     * @return
     */
    @Override
    public <R> Node<R> map(Function<T, R> converter) {
        return new ElementNode<>(this.nextNode.map(converter), converter.apply(this.data));
    }


    @Override
    public String toString() {
        String objstring = this.data.toString();
        String nextNode = this.nextNode.toString();
        if (nextNode.length() > 0)
            return objstring + "  \n\n" + nextNode;
        else
            return objstring;
    }

}