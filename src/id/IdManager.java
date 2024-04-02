package id;

import java.util.List;

public interface IdManager<T> {
    String generateId();
    T get(String id);
    List<T> getAll();
    boolean exists(String id);
    void add(T item);
    void delete(String id);
    void update(String id, T newItem);
}
