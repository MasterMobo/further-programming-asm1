package models.id;

import java.util.List;

public interface IdManager<T> extends Iterable<T>{
    String generateId();
    T get(String id);
    List<T> getAll();
    boolean exists(String id);
    T add(T item);
    T delete(String id);
    T update(String id, T newItem);
}
