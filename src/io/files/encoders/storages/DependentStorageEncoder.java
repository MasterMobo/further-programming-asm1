package io.files.encoders.storages;

import io.files.encoders.items.DependentEncoder;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;

public class DependentStorageEncoder extends StorageEncoder<DependentStorage, Dependent> {
    public DependentStorageEncoder() {
        super(new DependentEncoder());
    }
}
