package models.storage;

import java.util.List;

public interface Storage<T> extends Iterable<T>{
    String generateId();
    T get(String id);
    List<T> getAll();
    boolean exists(String id);
    T add(T item);
    T delete(String id);
    T update(String id, T newItem);
}
