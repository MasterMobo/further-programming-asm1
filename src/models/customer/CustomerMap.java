package models.customer;

import models.id.IdGenerator;
import models.id.IdMap;
import models.id.PrefixIdGenerator;

public abstract class CustomerMap<T extends Customer> extends IdMap<T> implements CustomerManager<T>{

    public CustomerMap() {
        super(new PrefixIdGenerator("c", 7));
    }

    @Override
    public String generateId() {
        // Generates a unique customer ID, ensuring uniqueness across all Customer instances in the system
        // WARNING: This method will only generate a unique ID, but will not add it to the ID set.
        // This is to give you some freedom on whether to use the generated ID or not.
        // However, if you decide to use the ID, you MUST add it to the ID set.
        // Otherwise, newer IDs will not be guaranteed to be unique.

        String candidateId = super.generateId();
        // If ID is already contained within the set, generate a new one
        while (Customer.customerIds.contains(candidateId)) {
            candidateId = super.generateId();
        }

        // At this point, the ID should be unique
        return candidateId;
    }
}
