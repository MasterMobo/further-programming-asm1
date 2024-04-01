package id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class IdMap <T extends Identifiable> implements IdManager<T>{
    // This class maps a unique ID (String) to an item of type T.
    // Type T has to implements the Identifiable interface, which means it needs a unique ID
    // This class serve as a basis for other mapping classes, providing the basic members of an ID map
    // This class must be implemented concretely according to specific use cases.

    protected Map<String, T> idToItem;

    public IdMap() {
        idToItem = new HashMap<>();
    }

    @Override
    public T get(String id) {
        // Returns the item correlating to the provided id
        // If no item exists, returns null
        return idToItem.get(id);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(idToItem.values());
    }

    @Override
    public boolean exists(String id) {
        return idToItem.containsKey(id);
    }

    @Override
    public void add(T item) {
        // Add new item to the map using the ID
        // If id already exists, replace the old item with the new one
        idToItem.put(item.getId(), item);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item: idToItem.values()) {
            s.append(item);
            s.append("\n");
        }

        return s.toString();
    }
}
