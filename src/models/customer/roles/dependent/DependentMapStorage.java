package models.customer.roles.dependent;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.roles.CustomerRoleMapStorage;
import models.system.StorageCode;

public class DependentMapStorage extends CustomerRoleMapStorage<Dependent> implements DependentStorage {
    public DependentMapStorage() {
        super();
    }

    @Override
    public String getId() {
        return StorageCode.DEPENDENTS;
    }
}
