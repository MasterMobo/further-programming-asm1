package models.customer;

import models.id.IdManager;

public interface CustomerRoleManager<T extends Customer> extends IdManager<T> {
    // This interface deals with all the customers of a specific role
}
