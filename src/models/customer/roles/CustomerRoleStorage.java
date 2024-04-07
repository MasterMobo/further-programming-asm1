package models.customer.roles;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.Customer;
import models.storage.Storage;
import models.storage.StorageItem;

public interface CustomerRoleStorage<T extends Customer> extends Storage<T>, StorageItem {
    // This interface deals with all the customers of a specific role
}
