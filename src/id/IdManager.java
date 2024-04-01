package id;

import java.util.List;

public interface IdManager<T> {
    T get(String id);
    List<T> getAll();
    boolean exists(String id);
    void add(T item);
}
