package models.customer.roles.dependent;

import models.customer.roles.CustomerRoleMapStorage;
import models.storage.StorageCode;

public class DependentMapStorage extends CustomerRoleMapStorage<Dependent> implements DependentStorage {
    public DependentMapStorage() {
        super();
    }

    @Override
    public String getId() {
        return StorageCode.DEPENDENTS;
    }
}
