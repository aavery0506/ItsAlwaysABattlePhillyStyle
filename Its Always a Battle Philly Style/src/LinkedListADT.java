import java.util.function.Predicate;

public interface LinkedListADT <T>{

    void addFront(T object);

    void addBack (T object);

    void add(int index, T object);

    int getSize();

    int getSize(Predicate<T> predicate);

    void remove (T object);

    //T get(int index) throws IllegalArgumentException;

    //LinkedListImpl<T> filter(Predicate<T> predicate);
}