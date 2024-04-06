package io.files.decoders.storages;

import io.files.DataSeparator;
import io.files.decoders.StringDecoder;
import models.storage.Storage;
import models.storage.StorageItem;

import java.util.List;

public abstract class StorageDecoder<T extends Storage<K>, K extends StorageItem> {
    private StringDecoder<K> itemDecoder;
    private T storage;
    public StorageDecoder() {
    }

    public StorageDecoder(StringDecoder<K> itemDecoder, T storage) {
        this.itemDecoder = itemDecoder;
        this.storage = storage;
    }

    public T decode(String s) {
        if (s.equals("")) return storage;
        System.out.println(parseItems(s));
        for (String itemString: parseItems(s)){
            K item = itemDecoder.decode(itemString);
            storage.add(item);
        }
        return storage;
    }

    private List<String> parseItems(String s) {
        return List.of(s.split(DataSeparator.STORAGE_ITEM));
    }
}
