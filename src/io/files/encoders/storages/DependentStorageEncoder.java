package io.files.encoders.storages;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.encoders.items.DependentEncoder;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;

public class DependentStorageEncoder extends StorageEncoder<DependentStorage, Dependent> {
    public DependentStorageEncoder() {
        super(new DependentEncoder());
    }
}
