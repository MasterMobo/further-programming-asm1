package models.customer;

import models.id.IdMap;
import models.id.PrefixIdGenerator;

public abstract class CustomerRoleMap<T extends Customer> extends IdMap<T> implements CustomerRoleManager<T> {

    public CustomerRoleMap() {
        super();
    }

    @Override
    public String generateId() {
        // ID Generation should NOT be handled by CustomerRoleMangers, but instead by CustomerManger to ensure uniqueness across different roles.
        return null;
    }
}
