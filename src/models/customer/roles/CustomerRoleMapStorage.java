package models.customer.roles;

import models.customer.Customer;
import models.storage.MapStorage;

public abstract class CustomerRoleMapStorage<T extends Customer> extends MapStorage<T> implements CustomerRoleStorage<T> {

    public CustomerRoleMapStorage() {
        super();
    }

    @Override
    public String generateId() {
        // ID Generation should NOT be handled by CustomerRoleMangers, but instead by CustomerManger to ensure uniqueness across different roles.
        return null;
    }
}
