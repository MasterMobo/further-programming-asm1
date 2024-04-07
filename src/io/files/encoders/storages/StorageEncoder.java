package io.files.encoders.storages;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.DataSeparator;
import io.files.encoders.StringEncoder;
import models.storage.Storage;
import models.storage.StorageItem;

public abstract class StorageEncoder<T extends Storage<K>, K extends StorageItem> extends StringEncoder<Storage<K>> {
    protected StringEncoder<K> itemEncoder;

    public StorageEncoder() {
    }

    public StorageEncoder(StringEncoder<K> itemEncoder) {
        this.itemEncoder = itemEncoder;
    }

    @Override
    public String encode(Storage<K> storage) {
        StringBuilder s = new StringBuilder();
        for (K item: storage) {
            s.append(itemEncoder.encode(item));
            s.append(DataSeparator.STORAGE_ITEM);
        }
        return s.toString();
    }
}
