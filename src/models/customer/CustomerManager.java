package models.customer;

import models.id.IdManager;

import java.util.List;

public interface CustomerManager<T extends Customer> extends IdManager<T> {
    // This interface deals with all the customers in the system
}
