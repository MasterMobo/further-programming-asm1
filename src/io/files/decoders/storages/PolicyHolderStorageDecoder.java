package io.files.decoders.storages;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.decoders.items.PolicyHolderDecoder;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;

public class PolicyHolderStorageDecoder extends StorageDecoder<PolicyHolderStorage, PolicyHolder> {
    public PolicyHolderStorageDecoder(PolicyHolderStorage storage) {
        super(new PolicyHolderDecoder(), storage);
    }
}
