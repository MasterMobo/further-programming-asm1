package models.storage;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import java.util.*;

public abstract class MapStorage<T extends StorageItem> implements Storage<T> {
    // This class maps a unique ID (String) to an item of type T.
    // Type T has to implements the Identifiable interface, which means it needs a unique ID
    // This class serve as a basis for other mapping classes, providing the basic members of an ID map
    // This class must be implemented concretely according to specific use cases.
    protected IdGenerator idGenerator;

    protected Map<String, T> map;


    public MapStorage() {
        idGenerator = null;
        map = new HashMap<>();
    }

    public MapStorage(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        map = new HashMap<>();
    }

    @Override
    public String generateId() {
        String id = idGenerator.randomId();

        // If ID already exists, generate new one
        while (exists(id)) {
            id = idGenerator.randomId();
        }
        return id;
    }

    @Override
    public T get(String id) {
        // Returns the item correlating to the provided models.id
        // If no item exists, returns null
        return map.get(id);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public boolean exists(String id) {
        return map.containsKey(id);
    }

    @Override
    public T add(T item) {
        // Add new item to the map using the ID
        // If models.id already exists, replace the old item with the new one
        map.put(item.getId(), item);
        return map.get(item.getId());
    }

    @Override
    public T delete(String id) {
        T previousItem = map.get(id);
        map.remove(id);
        return previousItem;
    }

    @Override
    public T update(String id, T newItem) {
        map.replace(id, newItem);
        return map.get(id);
    }

    @Override
    public Iterator<T> iterator() {
        return map.values().iterator();
    }

}
