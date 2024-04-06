package io.files.encoders.storages;

import io.files.encoders.items.PolicyHolderEncoder;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;

public class PolicyHolderStorageEncoder extends StorageEncoder<PolicyHolderStorage, PolicyHolder> {
    public PolicyHolderStorageEncoder() {
        super(new PolicyHolderEncoder());
    }
}
