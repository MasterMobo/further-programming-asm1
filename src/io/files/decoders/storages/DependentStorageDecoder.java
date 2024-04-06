package io.files.decoders.storages;

import io.files.decoders.items.DependentDecoder;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;

public class DependentStorageDecoder extends StorageDecoder<DependentStorage, Dependent> {
    public DependentStorageDecoder(DependentStorage storage) {
        super(new DependentDecoder(), storage);
    }
}
