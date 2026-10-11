import java.util.function.Function;
import java.util.function.Predicate;

public class EmptyNode<T> implements Node<T>{

    public int count(){
        return 0;
    }
    public int count(Predicate predicate){
        return 0;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Node<T> addFront(T object) {
        return new ElementNode<T>( this, object);
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Node<T> addBack(T object) {
        return addFront(object);
    }

    /**
     * @param index
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Node<T> add(int index, T object) throws IllegalArgumentException {
        if (index==0){
            return addFront(object);
        }
        throw new IllegalArgumentException("Invalid index to add an element");
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Node<T> remove(T object) {
        return this;
    }

    public String getString(){return "";}

    /**
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        throw new IllegalArgumentException("Invalid index");
    }

    @Override
    public Node<T> filter(Predicate p){
        return this;
    }

    @Override
    public Node<T> sort(Predicate p) {
        return new EmptyNode<T>();
    }

    @Override
    public Node insertNode(Predicate p,T data) {
        return null;
    }

    /**
     * @param p
     * @param index
     * @param data
     * @return
     */
    @Override
    public Node insertNode(Predicate p, int index, T data) {
        return null;
    }

    @Override
    public Node insert(Predicate p,T data) {
        return new ElementNode<T>(this,data);
    }

    @Override
    public <R> Node<R> map(Function<T, R> converter) {
        return new EmptyNode<>();
    }

    /**
     * @return
     */
    @Override
    public Node<T> remove(Predicate <T> predicate) {
        return this;
    }

    @Override
    public String toString(){
        return "";
    }

}