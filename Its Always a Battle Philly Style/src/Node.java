import java.util.function.Function;
import java.util.function.Predicate;

public interface Node <T> {

    int count();
    int count(Predicate <T> predicate);
    Node<T> addFront(T object);

    Node<T> addBack(T object);

    Node<T> add(int index, T object) throws IllegalArgumentException;

    Node<T> remove (T object);

    Node<T> remove(Predicate<T> predicate);

    Node<T> filter(Predicate<T> p);

    Node sort(Predicate p);

    Node insertNode (Predicate p,T data);

    T get(int index);

    String getString();

    Node insertNode(Predicate p, int index, T data);

    Node insert(Predicate p, T data);

    <R> Node<R> map(Function<T, R> converter);
}