package models.customer;

import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolderManager;
import models.id.IdGenerator;
import models.id.PrefixIdGenerator;

import java.util.HashSet;
import java.util.Set;

// TODO: find a better name for this
public class CustomerSystem implements CustomerManager{

    // This set contains the IDs of all customers within the system. This is used to ensure ID uniqueness across different user roles.
    private Set<String> customerIds;
    private PolicyHolderManager policyHolders;
    private DependentManager dependents;
    private IdGenerator idGenerator;

    public CustomerSystem() {
        policyHolders = null;
        dependents = null;
        customerIds = new HashSet<>();
        idGenerator = new PrefixIdGenerator("c", 10);
    }

    public CustomerSystem(PolicyHolderManager policyHolders, DependentManager dependents) {
        this.policyHolders = policyHolders;
        this.dependents = dependents;
        customerIds = new HashSet<>();
        idGenerator = new PrefixIdGenerator("c", 10);
    }

    @Override
    public String generateId() {
        // Generates a unique ID across all user roles.
        // This method will NOT add the returned ID to the ID set.
        // Use this method if you are only trying to generate a unique ID, but not use it to set the ID of a Customer
        // If you want to use the return value to set a Customer ID, use addID() after setting it.
        // Alternatively, use generateAndAddId() to accomplish this.

        String id = idGenerator.randomId();
        while (customerIds.contains(id)) {
            id = idGenerator.randomId();
        }

        return id;
    }

    @Override
    public void addId(String id) {
        // Adds an ID to the ID set.
        // This method should ALWAYS be used in tandem with generateId() if you are trying to set Customer ID.

        customerIds.add(id);
    }

    @Override
    public String generateAndAddId() {
        // Generates a unique ID then add it to the ID set.
        // This method should NOT be used to exclusively create Customer IDs. Doing so will not ensure uniqueness on subsequent calls.
        // Use this method ONLY if you are sure that the returned ID will be used to set Customer ID.

        String id = generateId();
        addId(id);
        return id;
    }

    public PolicyHolderManager getPolicyHolders() {
        return policyHolders;
    }

    public DependentManager getDependents() {
        return dependents;
    }
}
