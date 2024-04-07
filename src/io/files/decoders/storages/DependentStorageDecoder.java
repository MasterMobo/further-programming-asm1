package io.files.decoders.storages;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.decoders.items.DependentDecoder;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;

public class DependentStorageDecoder extends StorageDecoder<DependentStorage, Dependent> {
    public DependentStorageDecoder(DependentStorage storage) {
        super(new DependentDecoder(), storage);
    }
}
