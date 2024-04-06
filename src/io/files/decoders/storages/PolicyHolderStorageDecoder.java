package io.files.decoders.storages;

import io.files.decoders.items.PolicyHolderDecoder;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;

public class PolicyHolderStorageDecoder extends StorageDecoder<PolicyHolderStorage, PolicyHolder> {
    public PolicyHolderStorageDecoder(PolicyHolderStorage storage) {
        super(new PolicyHolderDecoder(), storage);
    }
}
