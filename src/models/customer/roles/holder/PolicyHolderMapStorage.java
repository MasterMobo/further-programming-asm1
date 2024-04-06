package models.customer.roles.holder;

import models.customer.roles.CustomerRoleMapStorage;
import models.storage.StorageCode;

public class PolicyHolderMapStorage extends CustomerRoleMapStorage<PolicyHolder> implements PolicyHolderStorage {
    public PolicyHolderMapStorage() {
        super();
    }

    @Override
    public String getId() {
        return StorageCode.POLICY_HOLDERS;
    }
}
